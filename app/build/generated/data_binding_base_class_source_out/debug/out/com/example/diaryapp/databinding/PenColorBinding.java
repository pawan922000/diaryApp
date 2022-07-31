// Generated by view binder compiler. Do not edit!
package com.example.diaryapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.diaryapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PenColorBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton blackpen;

  @NonNull
  public final FloatingActionButton bluepen;

  @NonNull
  public final LinearLayout color;

  @NonNull
  public final FloatingActionButton greenpen;

  @NonNull
  public final FloatingActionButton purplepen;

  @NonNull
  public final FloatingActionButton redpen;

  private PenColorBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton blackpen, @NonNull FloatingActionButton bluepen,
      @NonNull LinearLayout color, @NonNull FloatingActionButton greenpen,
      @NonNull FloatingActionButton purplepen, @NonNull FloatingActionButton redpen) {
    this.rootView = rootView;
    this.blackpen = blackpen;
    this.bluepen = bluepen;
    this.color = color;
    this.greenpen = greenpen;
    this.purplepen = purplepen;
    this.redpen = redpen;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PenColorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PenColorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pen_color, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PenColorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.blackpen;
      FloatingActionButton blackpen = ViewBindings.findChildViewById(rootView, id);
      if (blackpen == null) {
        break missingId;
      }

      id = R.id.bluepen;
      FloatingActionButton bluepen = ViewBindings.findChildViewById(rootView, id);
      if (bluepen == null) {
        break missingId;
      }

      id = R.id.color;
      LinearLayout color = ViewBindings.findChildViewById(rootView, id);
      if (color == null) {
        break missingId;
      }

      id = R.id.greenpen;
      FloatingActionButton greenpen = ViewBindings.findChildViewById(rootView, id);
      if (greenpen == null) {
        break missingId;
      }

      id = R.id.purplepen;
      FloatingActionButton purplepen = ViewBindings.findChildViewById(rootView, id);
      if (purplepen == null) {
        break missingId;
      }

      id = R.id.redpen;
      FloatingActionButton redpen = ViewBindings.findChildViewById(rootView, id);
      if (redpen == null) {
        break missingId;
      }

      return new PenColorBinding((ConstraintLayout) rootView, blackpen, bluepen, color, greenpen,
          purplepen, redpen);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
