package app.com.thetechnocafe.cyberoamclient.SavedAccounts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import app.com.thetechnocafe.cyberoamclient.Common.AccountsModel;
import app.com.thetechnocafe.cyberoamclient.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedAccountsActivity extends AppCompatActivity implements ISavedAccountsView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_accounts);

        //Butterknife bind
        ButterKnife.bind(this);
    }

    @Override
    public void setUpView() {
        //Set up toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onListDataReceived(List<AccountsModel> list) {

    }
}
