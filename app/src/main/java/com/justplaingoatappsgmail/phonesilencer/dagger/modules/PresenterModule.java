package com.justplaingoatappsgmail.phonesilencer.dagger.modules;

import com.justplaingoatappsgmail.phonesilencer.contracts.EventListContract;
import com.justplaingoatappsgmail.phonesilencer.contracts.EventPostContract;
import com.justplaingoatappsgmail.phonesilencer.model.database.RealmService;
import com.justplaingoatappsgmail.phonesilencer.presenter.EventListPresenter;
import com.justplaingoatappsgmail.phonesilencer.presenter.EventPostPresenter;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module(includes = {RealmModule.class})
public class PresenterModule {

    @Provides
    @Singleton
    public EventListContract.Presenter provideEventListPresenter(RealmService realmService) {
        return new EventListPresenter(realmService);
    }

    @Provides
    @Singleton
    public EventPostContract.Presenter provideEventPostPresenter(RealmService realmService) {
        return new EventPostPresenter(realmService);
    }

}
