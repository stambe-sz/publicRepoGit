package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodNameEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodService {
    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public void initMoods() {
        if (this.moodRepository.count() != 0){
            return;
        }

        Arrays.stream(MoodNameEnum.values())
                .forEach(moodNameEnum ->{
                    Mood mood = new Mood();
                    mood.setMoodName(moodNameEnum);
                    mood.setDescription("...");
                    this.moodRepository.save(mood);
                });

    }
}
