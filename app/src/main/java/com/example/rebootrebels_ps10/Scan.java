package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// implements onClickListener for the onclick behaviour of button
public class Scan extends AppCompatActivity implements View.OnClickListener {
    Button scanBtn;
    TextView messageText, messageFormat;
    TextView contentofProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        contentofProduct = findViewById(R.id.msg);

        // referencing and initializing
        // the button and textviews
        scanBtn = findViewById(R.id.scanBtn);
        messageText = findViewById(R.id.textContent);
        messageFormat = findViewById(R.id.textFormat);

        // adding listener to the button
        scanBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // we need to create the object
        // of IntentIntegrator class
        // which is the class of QR library
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan a barcode or QR Code");
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        // if the intentResult is null then
        // toast a message as "cancelled"

        HashMap<String, String[]> mapping = new HashMap<>();

        // Denver
        mapping.put("8901450010149",
                new String[]{"Butane (Propellant)", "Ethyl Alcohol", "Denatured Fragrance", "Aqua, Propylene Glycol",
                        "Diethyl Phthalate", "Triethyl Citrate", "Plastic"});
        // Fogg Fragrance Body Spray
        mapping.put("8908001158480",
                new String[]{"Aqua / Water", "Glycerin", "Alcohol", "Dipropylene Glycol", "Butylene Glycol", "Peg",
                        "Ppg", "Polybutylene Glycol", "Niacinamide", "Hydroxyethylpiperazine", "Ethane",
                        "Sulfonic Acid", "Bis-Peg-18", "Methyl Ether Dimethyl Silane", "Ethyl Ascorbic Acid",
                        "Isononyl Isononanoate", "Bht", "Linalool", "Geraniol", "Parfum", "Fragrance", "Salicylic Acid",
                        "Sodium Citrate", "Sodium Hyaluronate", "Phenoxyethanol", "Phenylethyl Resorcinol", "Adenosine",
                        "Ammonium Polyacryloyldimethyl Taurate", "Tocopheryl Acetate", "Disodium Edta", "Limonene",
                        "Hydrogenated Lecithin", "Citric Acid", "Citrus Limon Fruit Extract", "Lemon Fruit Extract",
                        "Citrus Junos Fruit Extract", "Xanthan Gum", "Maltodextrin",
                        "Acetyl Trifluoromethylphenyl Valylglycine", "Oxothiazolidinecarboxylic Acid",
                        "Benzyl Salicylate", "Benzyl Alcohol","Triclosan"
                });
        // 50 50
        mapping.put("8901063017627",
                new String[]{
                        " Wheat Flour (Gluten) ", "Vegetable Fat (Palm) & Palm Olein Oil", "Sugar (19%)",
                        " Raising Agents (Sodium Bicarbonate,Acid Calcium Phosphate & Ammonium Bicarbonate)",
                        "Invert Sugar", "Salt(1%)", "Yeast",
                        "Artificial Flavourings (Butter , Vanilla & Milk)",
                        " Acidity Regulators (Lactic Acid & Citric Acid)",
                        " Flour Treatment Agents (Sodium Metabisulphite (Sulphite))", " Fungal Alpha Amylase",
                        "Bacterial Protease"
                });

        // Garnier
        mapping.put(" 8901526005161",
                new String[]{"Aqua / Water", "Glycerin", "Alcohol", "Dipropylene Glycol", "Butylene Glycol", "Peg",
                        "Ppg", "Polybutylene Glycol", "Niacinamide", "Hydroxyethylpiperazine", "Ethane",
                        "Sulfonic Acid", "Bis-Peg-18", "Methyl Ether Dimethyl Silane", "Ethyl Ascorbic Acid",
                        "Isononyl Isononanoate", "Bht", "Linalool", "Geraniol", "Parfum", "Fragrance", "Salicylic Acid",
                        "Sodium Citrate", "Sodium Hyaluronate", "Phenoxyethanol", "Phenylethyl Resorcinol", "Adenosine",
                        "Ammonium Polyacryloyldimethyl Taurate", "Tocopheryl Acetate", "Disodium Edta", "Limonene",
                        "Hydrogenated Lecithin", "Citric Acid", "Citrus Limon Fruit Extract", "Lemon Fruit Extract",
                        "Citrus Junos Fruit Extract", "Xanthan Gum", "Maltodextrin",
                        "Acetyl Trifluoromethylphenyl Valylglycine", "Oxothiazolidinecarboxylic Acid",
                        "Benzyl Salicylate", "Benzyl Alcohol","Triclosan"
                });
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                // if the intentResult is not null we'll set
                // the content and format of scan message

                messageText.setText(intentResult.getContents());
                String code = (String) messageText.getText();
                messageFormat.setText(intentResult.getFormatName());

//                contentofProduct.setText(mapping.get(code).toString());

                ArrayList<String> harmfuList = new ArrayList<>();
                String[] str = new String[]{"Triclosan", "Exfoliating Microbeads", "Oxybenzone", "Synthetic Fragrances",
                        "Plastic", "Polyethylene Terephthalate", "Polyethylene", "Sodium Lauryl Sulfate", "Formaldehyde",
                        "Parabens", "Methylparaben", "Propylparaben", "Butylparaben", "Ethylparaben", "Polypropylene",
                        "Phthalates", "Nonylphenol Ethoxylates", "Bisphenol A"};
                Collections.addAll(harmfuList, str);
//                String st = "8901063017627"; // change here
                ArrayList<String> harmfulingredients = new ArrayList<>();

                if (mapping.containsKey(code)) {
                    List<String> ingredients = Arrays.asList(mapping.get(code));
                    for (int i = 0; i < ingredients.size(); i++) {
                        if (harmfuList.contains(ingredients.get(i))) {
                            harmfulingredients.add(ingredients.get(i));
                        }
                    }
                    if (harmfulingredients.size() != 0)
                        contentofProduct.setText(harmfulingredients.toString());
                    else
                        contentofProduct.setText("No harmful ingredients");
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
