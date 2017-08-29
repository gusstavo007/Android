package pe.area51.clase03.screens.welcome.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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


            imgCurrent = R.drawable.img_2+i;

            if (isNetDisponible() || isOnlineNet())
                //Asignamos imagen de internet
                user.setPhoto("http://segundoacosta.com/static/sample_" + i + ".jpg");

            else
                user.setPhoto("res:///" + imgCurrent);



            //Añadimos el objeto al arreglo
            Clase03Globals.lista.add(user);

        }


        adapter = new UserAdapter(context, Clase03Globals.lista);
        users.setAdapter(adapter);


    }
    private boolean isNetDisponible() {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo actNetInfo = connectivityManager.getActiveNetworkInfo();

        return (actNetInfo != null && actNetInfo.isConnected());
    }
    public Boolean isOnlineNet() {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }


}
