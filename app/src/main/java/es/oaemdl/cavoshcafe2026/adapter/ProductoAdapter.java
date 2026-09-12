package es.oaemdl.cavoshcafe2026.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import es.oaemdl.cavoshcafe2026.R;
import es.oaemdl.cavoshcafe2026.entity.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private Context context;
    private List<Producto> productos;

    public ProductoAdapter(Context context, List<Producto> productos){
        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.fragment_card_view_component, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        Producto producto = productos.get( position );
        holder.tvProducto.setText( String.format( "%s\n%s", producto.getDetalle(), producto.getDescripcion() ) );
        holder.tvPrecio.setText( new DecimalFormat( "###.##").format( producto.getPrecio() ) );

        Picasso.get()
                .load("URL...." + producto.getId() + ".jpg" )
                .fit().centerCrop()
                .placeholder(R.drawable.ic_imagen)
                .error( R.drawable.ic_imagen )
                .into( holder.ivProducto );

        holder.itemView.setOnClickListener(v -> {

        } );
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProducto, imgPlus,imgFavorite;
        TextView tvName, tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProducto = itemView.findViewById(R.id.imgProduct);
            imgFavorite = itemView.findViewById(R.id.imgFavorite);
            imgPlus = itemView.findViewById(R.id.imgPlus);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
