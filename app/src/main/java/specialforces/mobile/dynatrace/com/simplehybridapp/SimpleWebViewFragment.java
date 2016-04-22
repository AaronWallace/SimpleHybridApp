package specialforces.mobile.dynatrace.com.simplehybridapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SimpleWebViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SimpleWebViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleWebViewFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private WebView webView;
    String url;

    public SimpleWebViewFragment() {
        // Required empty public constructor
    }

    public static SimpleWebViewFragment newInstance(int tabId, String url) {
        SimpleWebViewFragment thisFrag = new SimpleWebViewFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        thisFrag.setArguments(args);
        return thisFrag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString("url");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        webView.loadUrl(url);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View thisView = inflater.inflate(R.layout.fragment_web_view, container, false);
        webView = (WebView) thisView.findViewById(R.id.webView2);
        webView.setWebViewClient(new WebViewClient());
        return thisView;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
