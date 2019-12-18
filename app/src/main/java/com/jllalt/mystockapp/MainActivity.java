package com.jllalt.mystockapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.jllalt.mystockapp.configuration.DaggerAppComponent;
import com.jllalt.mystockapp.data.manager.ProductManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ProductManager productManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.create().inject(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    public void openScan(View view) {
        if (view.getId() == R.id.iv_scan_code_barre) {
            // on lance le scanner au clic sur notre bouton
            new IntentIntegrator(this).initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // TODO : implémenter le retour du scan
        // Récupérer le code barre scannée
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            // nous récupérons le contenu du code barre
            String codeEan = scanningResult.getContents();
            Toast.makeText(this.getApplicationContext(), "Code barre : " + codeEan, Toast.LENGTH_SHORT).show();
            productManager.addProduct(codeEan);
        }
        // Appeler le service de récupération des informations.
        // Ouvrir popup avec les informations de l'article.
    }
}
