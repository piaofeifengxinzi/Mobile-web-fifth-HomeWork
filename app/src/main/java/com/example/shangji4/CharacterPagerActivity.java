package com.example.shangji4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.UUID;

//上机五新加的类
public class CharacterPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<Character> mCharacter;

    public static Intent newIntent(Context packageContext, UUID CharacterId){
        Intent intent = new Intent(packageContext,CharacterPagerActivity.class);
        intent.putExtra(CharacterActivity.EXTRA_CRIME_ID,CharacterId);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);

        UUID CharacterId = (UUID) getIntent().getSerializableExtra(CharacterActivity.EXTRA_CRIME_ID);
        //控件绑定
        viewPager = (ViewPager)findViewById(R.id.activity_crime_pager_view_pager);
        mCharacter = CharacterLab.get(this).getmCharacters();
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Character character = mCharacter.get(position);
                return CharacterFragment.newInstance(character.getmId());
            }

            @Override
            public int getCount() {
                return mCharacter.size();
            }
        });
        for(int i=0;i<mCharacter.size();i++){
            if (mCharacter.get(i).getmId().equals(CharacterId)){
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
