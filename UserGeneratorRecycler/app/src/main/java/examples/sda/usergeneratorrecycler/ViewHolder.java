package examples.sda.usergeneratorrecycler;

import android.view.View;
import android.widget.TextView;

/**
 * Created by angelika on 11.05.17.
 */

public class ViewHolder {

    private TextView fullName;
    private TextView birthDate;
    private TextView phoneNumber;
    private TextView email;

    public ViewHolder(View v) {
        super();
        fullName = (TextView) v.findViewById(R.id.full_name);
        birthDate = (TextView) v.findViewById(R.id.birth_date);
        phoneNumber = (TextView) v.findViewById(R.id.phone_number);
        email = (TextView) v.findViewById(R.id.email);


    }
}
