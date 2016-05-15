package com.sttimchenko.censushelper.aims;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sttimchenko.censushelper.Constants;
import com.sttimchenko.censushelper.R;
import com.sttimchenko.censushelper.form.FormActivity;
import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

public class AimsFragment extends Fragment implements AimsView, AimsAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AimsPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_global_aims, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        AimsModel model = new AimsModelImpl();

        presenter = new AimsPresenterImpl(this, model);

        presenter.onCreate(getActivity(), savedInstanceState);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.requestAdapterData();
    }

    @Override
    public void onItemClick(View v, int position) {
        presenter.onItemChosen(position);
    }

    @Override
    public void onAdapterData(List<Aim> list) {
        AimsAdapter adapter = new AimsAdapter(list, this, getContext());
        adapter.setListener(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showConcreteDialog(final List<String> list, final int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Оберіть номер квартири");

        builder.setItems(list.toArray(new String[list.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.onItemChosen(index, Integer.valueOf(list.get(which)));
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Відміна", null);

        builder.show();
    }

    @Override
    public void onChoiceMade(int aimId, int flatNumber) {
        Intent intent = new Intent(getActivity(), FormActivity.class);
        intent.putExtra(Constants.EXTRA_KEY_ID, aimId);
        intent.putExtra(Constants.EXTRA_KEY_FLAT, flatNumber);
        getContext().startActivity(intent);
    }
}
