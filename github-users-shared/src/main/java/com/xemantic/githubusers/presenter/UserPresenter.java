/*
 * github-users - lists GitHub users. Minimal app demonstrating
 * cross-platform development (Web, Android, iOS) on top of
 * Java to JavaScript and Java to Objective-C transpilers.
 *
 * Copyright (C) 2017  Kazimierz Pogoda
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.xemantic.githubusers.presenter;

import com.xemantic.githubusers.event.UserSelectedEvent;
import com.xemantic.githubusers.eventbus.EventBus;
import com.xemantic.githubusers.model.User;
import com.xemantic.githubusers.view.UserView;

import javax.inject.Inject;

/**
 * Presenter of the {@link UserView}.
 *
 * @author morisil
 */
public class UserPresenter {

  private final EventBus eventBus;

  @Inject
  public UserPresenter(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  void start(User user, UserView view) {
    view.observeSelection().subscribe(s -> eventBus.post(new UserSelectedEvent(user)));
    view.displayLogin(user.getLogin());
  }

}
