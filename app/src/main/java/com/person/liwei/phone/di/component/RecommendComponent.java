package com.person.liwei.phone.di.component;


import com.person.liwei.phone.di.FragmentScope;
import com.person.liwei.phone.di.module.RemmendModule;
import com.person.liwei.phone.ui.fragment.RecommendFragment;

import dagger.Component;

@FragmentScope
@Component(modules = RemmendModule.class,dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);
}
