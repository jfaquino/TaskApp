package ado.edu.itla.taskapp.vista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Categoria;

/**
 * Created by MESCyT on 23/6/2018.
 */

public class CategoriaListAdapter extends BaseAdapter{

    private Context context;
    private List<Categoria> categorias;

    public CategoriaListAdapter(Context context, List<Categoria> categorias) {
        this.context = context;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return categorias.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //TODO: Validr si view no es nulo

        if(view == null){

            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.categoria_listview_row, null, true);
        }

        TextView lbCategoriaId = view.findViewById(R.id.lbCategoriaId);
        TextView lbCategoriaNombre = view.findViewById(R.id.lbCategoriaNombre);

        Categoria cat = categorias.get(i);

        lbCategoriaId.setText(cat.getId().toString());
        lbCategoriaNombre.setText(cat.getNombre());
        return view;
    }
}
