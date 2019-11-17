package com.example.finalexam07600632.DB;

import android.content.Context;
import android.os.AsyncTask;

import com.example.finalexam07600632.model.login;

import java.util.List;

public class loginRepository {
    private Context context;

    public loginRepository(Context context) {
        this.context = context;
    }

    public  void getLogin(callBack callBack){
        GetTask getTask = new GetTask(context,callBack);
        getTask.execute();
    }
    public  void InsertLogin(login item, insertCallBack insertCallBack){
        InsertTask insertTask = new InsertTask(context,insertCallBack);
        insertTask.execute(item);
    }
    private static class GetTask extends  AsyncTask<Void,Void, List<login>>{
        private Context mContext;
        private callBack callBack;
        public GetTask(Context mContext , callBack callBack) {
            this.mContext = mContext;
            this.callBack = callBack;

        }


        @Override
        protected List<login> doInBackground(Void... voids) {
            AppDB db = AppDB.getInstance(mContext);
            List<login> l1 = db.loginDAO().getAll();
            return l1;
        }

        @Override
        protected void onPostExecute(List<login> loginItems) {
            super.onPostExecute(loginItems);
            callBack.getloginCallBack(loginItems);

        }
    }

    public interface callBack{
        void getloginCallBack(List<login> loginItemList);
    }

    public interface insertCallBack{
        void onInsertCallBack();
    }


    private static class InsertTask extends AsyncTask<login,Void, Void> {
        private Context mContext;
        private insertCallBack insertCallBack;
        public InsertTask(Context mContext , insertCallBack insertCallBack) {
            this.mContext = mContext;
            this.insertCallBack = insertCallBack;
        }

        @Override
        protected Void doInBackground(login... loginItems) {
            AppDB db = AppDB.getInstance(mContext);
            db.loginDAO().insert(loginItems[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            insertCallBack.onInsertCallBack();
        }


    }
}
