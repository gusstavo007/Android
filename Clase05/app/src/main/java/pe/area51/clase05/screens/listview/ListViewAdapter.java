package pe.area51.clase05.screens.listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import pe.area51.clase05.R;
import pe.area51.clase05.helpers.frescolib.HelperImageClase03;
import pe.area51.clase05.models.PersonModel;
import pe.area51.clase05.screens.gridview.GridViewAdapter;

/**
 * Created by Gustavo on 27/08/2017.
 */

public class ListViewAdapter extends ArrayAdapter<PersonModel> {

    Context context;

    TextView name_people;
    public ListViewAdapter(@NonNull Context context, ArrayList<PersonModel> person) {
        super(context,0 , person);

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
       ViewHolder vh;


        if (view == null) {

            vh = new ViewHolder();
            view = LayoutInflater.from(context)
                    .inflate(R.layout.person_list_item, parent, false);

            vh.photo = (SimpleDraweeView) view.findViewById(R.id.profile_pic);
             name_people = (TextView) view.findViewById(R.id.namePeople);

            //name_people.setText(position);

            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

           HelperImageClase03 loader = new HelperImageClase03(context);
           loader.view = vh.photo;
           loader.url = getItem(position).getPhoto();

            loader.show();

        return view;

    }
    static class ViewHolder {
        SimpleDraweeView photo;

    }
}
