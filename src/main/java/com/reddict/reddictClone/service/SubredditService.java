package com.reddict.reddictClone.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reddict.reddictClone.dto.SubredditDto;
import com.reddict.reddictClone.exceptions.SpringRedditException;
import com.reddict.reddictClone.mapper.SubredditMapper;
import com.reddict.reddictClone.model.Subreddit;
import com.reddict.reddictClone.repository.SubredditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubredditService {
	private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }

}

