package app.com.thetechnocafe.cyberoamclient.Login;

import android.content.Context;

/**
 * Created by gurleensethi on 18/10/16.
 */

public interface ILoginView {
    void isLoginSuccessful(boolean success, String message);

    void setUpOnClickListeners();

    Context getContext();

    void setUpSavedState(String username, String password);

    void completeFirstRunSetup();

    void onRefreshState(boolean isLoggedIn);

    void isContinuousLoginEnabled(boolean isEnabled);
}
