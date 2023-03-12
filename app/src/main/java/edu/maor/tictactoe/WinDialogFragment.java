package edu.maor.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class WinDialogFragment extends DialogFragment {
    String result;
    TextView message;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.win_dialog, null);

        builder.setPositiveButton(R.string.back, (DialogInterface.OnClickListener) (dialog, id) -> startActivity(new Intent(this.getContext(), MainActivity.class)))
                .setNegativeButton(R.string.new_game, (DialogInterface.OnClickListener) (dialog, id) -> startActivity(new Intent(this.getContext(), TicTacToe.class)));

        builder.setView(v);

        message = v.findViewById(R.id.msg);
        result = getArguments().getString("MESSAGE");

        message.setText(result);

        return builder.create();
    }
}
