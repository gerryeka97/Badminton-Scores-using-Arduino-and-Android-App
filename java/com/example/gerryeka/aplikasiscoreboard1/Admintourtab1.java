package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_admintourmatch;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_tourmatch;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_admintourmatch;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_tourmatch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Admintourtab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Admintourtab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Admintourtab1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String admintour_id;
    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    ArrayList<Model_admintourmatch> tourmatches;

    public Admintourtab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Admintourtab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Admintourtab1 newInstance(String param1, String param2) {
        Admintourtab1 fragment = new Admintourtab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        admintour_id = ((Admintournamentmatch)getActivity()).getidtournament();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_admintourtab1, container,false);

        recyclerView = rootView.findViewById(R.id.admintourmatchlist1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        tourmatches = new ArrayList<Model_admintourmatch>();

        Admintourtab1.JsonFetch jsonFetch = new Admintourtab1.JsonFetch();
        jsonFetch.execute();
        // Inflate the layout for this fragment
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class JsonFetch extends AsyncTask<String, String, String> {

        HttpURLConnection httpURLConnection = null;
        String mainfile;

        @Override
        protected String doInBackground(String... strings) {

            try {
//                URL url = new URL("http://192.168.0.19/loginapp/admintourmatches.php?id_tour="+ admintour_id);
//                URL url = new URL("http://203.189.121.229:9000/loginapp/admintourmatches.php?id_tour="+ admintour_id");
                URL url = new URL("http://192.168.43.38/loginapp/admintourmatches.php?id_tour="+ admintour_id);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);

                }
                mainfile = stringBuffer.toString();
                JSONArray parent = new JSONArray(mainfile);
                int i = 0;
                while (i <= parent.length()) {
                    JSONObject child = parent.getJSONObject(i);
                    String adminmatchid = child.getString("match_id");
                    String admintname1 = child.getString("tname1");
                    String admintname2 = child.getString("tname2");
                    String admintscore1 = child.getString("tset_score1");
                    String admintscore2 = child.getString("tset_score2");
                    String admintourid = child.getString("tournament_id");
                    String adminround = child.getString("round");

                    tourmatches.add(new Model_admintourmatch(adminmatchid, admintname1, admintname2, admintscore1, admintscore2, admintourid, adminround));

                    i++;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Adapter_admintourmatch adapter_admintourmatch = new Adapter_admintourmatch(tourmatches,getActivity());
            recyclerView.setAdapter(adapter_admintourmatch);
        }

    }
}
