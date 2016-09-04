package by.bsuir.clientsdata;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by User on 04.09.2016.
 */
public class DBConnection extends AsyncTask<Void, Void, Void>{

    String url = "jdbc:mysql://192.168.0.106:3306/bank_db";
    String user = "root";
    String password = "";
    Context mContext;

    public DBConnection(Context context) {
        mContext = context;

    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            String sql = "select * from client";
            ResultSet res = st.executeQuery(sql);
            res.next();
            Toast toast = Toast.makeText(mContext, res.getString(3), Toast.LENGTH_SHORT);
            toast.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
