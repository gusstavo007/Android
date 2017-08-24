package pe.area51.clase03.screens.welcome.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import pe.area51.clase03.Clase03Globals;
import pe.area51.clase03.R;
import pe.area51.clase03.models.UserModel;

public class WelcomeActivity extends AppCompatActivity {

    Context context;

    UserAdapter adapter;
    ListView users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        users = (ListView) findViewById(R.id.users);

        context = this;
        loadUsers();

    }

    public void loadUsers() {

        if (Clase03Globals.lista == null) {
            Clase03Globals.lista = new ArrayList<UserModel>();
        }

        int imgCurrent = 0;
        for (int i = 0; i < 7; i++) {

            //Creamos un objeto
            UserModel user = new UserModel();
            //Le enviamos la información de las propiedades del objeto
            user.setName("Nombre " + i);
            user.setDescription("Descripción" + i);
            //Asignamos dirección de la foto

           Log.d("im22222", "" + R.drawable.img_2);


            imgCurrent = R.drawable.img_2+i;
            Log.d("im1", "res:///" + imgCurrent);


            user.setPhoto("res:///" + imgCurrent);

            //user.setPhoto("res:///R.drawable.img_" + i);
            //Asignamos imagen de internet
            //user.setPhoto("http://segundoacosta.com/static/sample_" + i + ".jpg");

            //draweeView.setImageURI();
            //Añadimos el objeto al arreglo
            Clase03Globals.lista.add(user);

        }


        adapter = new UserAdapter(context, Clase03Globals.lista);
        users.setAdapter(adapter);


    }


}
