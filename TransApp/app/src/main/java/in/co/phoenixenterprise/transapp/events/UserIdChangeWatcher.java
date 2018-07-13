package in.co.phoenixenterprise.transapp.events;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class UserIdChangeWatcher implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("TransApp","before text change CharSequence s: "+ s);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("TransApp","on text change CharSequence s: "+ s);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d("TransApp","after text change Editable s: "+ s);
    }
}
