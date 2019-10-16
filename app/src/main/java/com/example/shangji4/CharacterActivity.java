package com.example.shangji4;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class CharacterActivity extends MainActivity {
    public static final String EXTRA_CRIME_ID = "com.example.shangji4.mylable";
    @Override
    protected Fragment createFragment(){
//        return new CharacterFragment();
        UUID characterId = (UUID)getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CharacterFragment.newInstance(characterId);
    }
}
