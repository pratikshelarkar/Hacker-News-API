package com.example.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Comments;
import com.example.model.Story;

@RestController
public class TopStoriesController {

	private static final String BASE_URL = "https://hacker-news.firebaseio.com/v0/";

	private final List<List<Story>> pastStories = new ArrayList<>();

	private final RestTemplate restTemplate;
	List<Story> cachedData;

	@Autowired
	public TopStoriesController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/top-stories")
	@Cacheable("myCache")
	public List<Story> getTopStories() throws IOException {
		String url = BASE_URL + "topstories.json";
		Integer[] topStoryIds = restTemplate.getForObject(url, Integer[].class);
		List<Integer> topTenStoryIds = Arrays.asList(topStoryIds).subList(0, 10);
		List<Story> topTenStories = new ArrayList<>();
			for (int id : topTenStoryIds) {
				String storyUrl = BASE_URL + "item/" + id + ".json";
				Map<?, ?> story = restTemplate.getForObject(storyUrl, Map.class);

				String title = (String) story.get("title");
				String url2 = (String) story.get("url");
				int score = (int) story.get("score");
				int id2 = (int) story.get("id");
				List<Integer> kids = (List<Integer>) story.get("kids");
				LocalDateTime submissionTime = LocalDateTime.ofEpochSecond((int) story.get("time"), 0, ZoneOffset.UTC);
				String submitter = (String) story.get("by");

				Story topStory = new Story(id2, title, url2, score, submissionTime, submitter, kids);
				topTenStories.add(topStory);
			}
			pastStories.add(topTenStories);
		return topTenStories;
	}

	@GetMapping("/past-stories")
	public List<List<Story>> getPastStories() {
		return pastStories;
	}

	@GetMapping("/comments")
	public List<Comments> getComments(@RequestParam("storyId") int storyId) {
		String url = BASE_URL + "item/" + storyId + ".json";
		Map<?, ?> story = restTemplate.getForObject(url, Map.class);

		List<Integer> commentIds = (List<Integer>) story.get("kids");
		List<Comments> comments = new ArrayList<>();
		for (Integer commentId : commentIds) {
			url = BASE_URL + "item/" + commentId + ".json";
			Map<?, ?> comment = restTemplate.getForObject(url, Map.class);

			int id = (int) comment.get("id");
			String comment_text = (String) comment.get("text");
			String comment_by = (String) comment.get("by");
			int time = (int) comment.get("time");
			List<Integer> kids = (List<Integer>) comment.get("kids");
			Comments comment1 = new Comments(id, comment_text, comment_by, time, kids);
			comments.add(comment1);
		}

//          comments.sort(Comparator.comparingInt(comment -> comment.getKids()));
		if (comments.size() > 10) {
			comments = comments.subList(0, 10);
		}

		return comments;
	}
}
