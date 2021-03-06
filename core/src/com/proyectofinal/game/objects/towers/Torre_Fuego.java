package com.proyectofinal.game.objects.towers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.proyectofinal.game.helpers.AssetManager;
import com.proyectofinal.game.objects.towers.attack.Fuego;

/**
 * Created by ALUMNEDAM on 05/05/2017.
 */

public class Torre_Fuego extends Torres {
    private Fuego fuego;

    public Torre_Fuego(float x, float y, boolean orientacion, float circuloWidth, float circuloHeight, int radio, int vida, int danyo, String tipo) {
        super(x, y, orientacion, circuloWidth, circuloHeight, radio, vida, danyo, tipo);

        fuego = new Fuego(x + circuloWidth / 2, y + circuloHeight / 2, radio);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (orientacion) {  //Dependiendo de la orientación y de si esta viva, se mostrara una imagen o no
            if (viva) {
                batch.draw(AssetManager.torreF, getX(), getY());
                if (overlaps) { //Si hay tropas colisionadas se mostrara el fuego o no
                    fuego.setVisible(true);
                } else {
                    fuego.setVisible(false);
                }

            } else {
                batch.draw(AssetManager.torreFMuerta, getX(), getY());
                fuego.setVisible(false);
            }
        } else {
            if (viva) {
                batch.draw(AssetManager.torreF2, getX(), getY());
                if (overlaps) {
                    fuego.setVisible(true);
                } else {
                    fuego.setVisible(false);
                }
            } else {
                batch.draw(AssetManager.torreF2Muerta, getX(), getY());
                fuego.setVisible(false);
            }

        }
        fuego.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        fuego.setTiempoDeEstado(fuego.getTiempoDeEstado() + (delta / 2));
    }

}
