import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public CheckBox checkBox;

    public ItemViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_image);
        checkBox = itemView.findViewById(R.id.item_checkbox);
    }
}
