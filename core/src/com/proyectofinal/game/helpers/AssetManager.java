package com.proyectofinal.game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.proyectofinal.game.utils.Settings;

/**
 * Created by ALUMNEDAM on 25/04/2017.
 */

public class AssetManager {

    //Atibutos como Texturas.
    public static Texture fondo, textureBtnCont, textureBtnReiniciar, textureBtnSalir, textureBtnSig, textureMusic, textureMusicMute, textureAttackMusic, textureAttackMusicMute;
    //Atributos de Animaciones
    public static Animation<TextureRegion> caballeroRun, caballeroAttack, ninjaRun, ninjaAttack, robotRun, robotAttack, robotBullet, robotMuzzle, fuegoTorre, rayoTorre;

    //Sprites
    public static Sprite caballeroSelec, ninjaSelec, robotSelec, mapa1, mapa2, btnContinuar, caballeroSelecAtak, ninjaSelecAtak, robotSelecAtak, btnReiniciar, btnSalir, btnSig, musicIcono, musicMute, musicIconoAttack, musicMuteAttack;
    public static Sprite torreF, torreF2, torreFMuerta, torreF2Muerta, torreR, torreR2, torreRMuerta, torreR2Muerta;

    //Bitmap para difeentes fuentes
    public static BitmapFont fontGrande, font, fontPequenia;
    //estilo de las letras
    public static Label.LabelStyle textStyle, textStyleTitulo, textStylePequenio;

    //Texture Region para poner el fondo
    public static TextureRegion background;

    //Camera
    public static OrthographicCamera camera;

    //TiledMap
    public static TiledMap tiledMap1, tiledMap2;
    //OrthogonalTiledMapRenderer
    public static OrthogonalTiledMapRenderer renderer;

    public static Music musicStart, musicEnd;
    public static Sound soundMelee, soundTowerDead, soundWalk, soundFire, soundThunder, soundShoot;

    /**
     * Methodo Load
     */
    public static void load() {

        //Carrgamos las texturas en sprites
        caballeroSelecAtak = new Sprite(new Texture(Gdx.files.internal("tropas/caballeroSelec_prueba.png")));
        caballeroSelecAtak.flip(true, false);

        ninjaSelecAtak = new Sprite(new Texture(Gdx.files.internal("tropas/ninjaSelec_prueba.png")));
        ninjaSelecAtak.flip(true, false);

        robotSelecAtak = new Sprite(new Texture(Gdx.files.internal("tropas/robotSelec_prueba.png")));
        robotSelecAtak.flip(true, false);


        //Carrgamos les textures para poner de fondo
        fondo = new Texture(Gdx.files.internal("fondos/fondo_degradado.jpg"));
        //Ponemos el fondo
        fondo.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        background = new TextureRegion(fondo);
        background.flip(false, true);

        //Se carga la textura de mapa en sprite.
        mapa1 = new Sprite(new Texture(Gdx.files.internal("texturas/mapa1.png")));
        mapa1.flip(false, true);

        mapa2 = new Sprite(new Texture(Gdx.files.internal("texturas/mapa2.png")));
        mapa2.flip(false, true);

        //Carrgamos las texturas de selecionar tropas en sprites.
        caballeroSelec = new Sprite(new Texture(Gdx.files.internal("tropas/caballeroSelec_prueba.png")));
        caballeroSelec.flip(false, true);

        ninjaSelec = new Sprite(new Texture(Gdx.files.internal("tropas/ninjaSelec_prueba.png")));
        ninjaSelec.flip(false, true);

        robotSelec = new Sprite(new Texture(Gdx.files.internal("tropas/robotSelec_prueba.png")));
        robotSelec.flip(false, true);

        //Carrgamos las texturas de torres en sprites, de diferentes sentidos.
        torreF = new Sprite(new Texture(Gdx.files.internal("torres/torreFuego.png")));
        torreF.flip(true, false);

        torreF2 = new Sprite(new Texture(Gdx.files.internal("torres/torreFuego2.png")));
        torreF2.flip(true, false);

        torreFMuerta = new Sprite(new Texture(Gdx.files.internal("torres/torreFuego_muerta.png")));
        torreFMuerta.flip(true, false);

        torreF2Muerta = new Sprite(new Texture(Gdx.files.internal("torres/torreFuego2_muerta.png")));
        torreF2Muerta.flip(true, false);

        torreR = new Sprite(new Texture(Gdx.files.internal("torres/torreRayo.png")));
        torreR.flip(true, false);

        torreR2 = new Sprite(new Texture(Gdx.files.internal("torres/torreRayo2.png")));
        torreR2.flip(true, false);

        torreRMuerta = new Sprite(new Texture(Gdx.files.internal("torres/torreRayo_muerta.png")));
        torreRMuerta.flip(true, false);

        torreR2Muerta = new Sprite(new Texture(Gdx.files.internal("torres/torreRayo2_muerta.png")));
        torreR2Muerta.flip(true, false);


        //Texturas de botones, para continuar , siguiente reiniciar y salir
        textureBtnCont = new Texture(Gdx.files.internal("otros/ContinuarBtn1.png"));
        btnContinuar = new Sprite(textureBtnCont);
        btnContinuar.flip(false, true);

        textureBtnReiniciar = new Texture(Gdx.files.internal("otros/Reiniciar.png"));
        btnReiniciar = new Sprite(textureBtnReiniciar);
        btnReiniciar.flip(false, true);

        textureBtnSalir = new Texture(Gdx.files.internal("otros/Salir.png"));
        btnSalir = new Sprite(textureBtnSalir);
        btnSalir.flip(false, true);

        textureBtnSig = new Texture(Gdx.files.internal("otros/Siguiente.png"));
        btnSig = new Sprite(textureBtnSig);
        btnSig.flip(false, true);

        textureMusic = new Texture(Gdx.files.internal("otros/musicIcono.png"));
        musicIcono = new Sprite(textureMusic);
        musicIcono.flip(false, true);

        textureMusicMute = new Texture(Gdx.files.internal("otros/musicIconoMute.png"));
        musicMute = new Sprite(textureMusicMute);
        musicMute.flip(false, true);


        textureAttackMusic = new Texture(Gdx.files.internal("otros/musicIconoAttack.png"));
        musicIconoAttack = new Sprite(textureAttackMusic);
        musicIconoAttack.flip(false, true);

        textureAttackMusicMute = new Texture(Gdx.files.internal("otros/musicIconoMuteAttack.png"));
        musicMuteAttack = new Sprite(textureAttackMusicMute);
        musicMuteAttack.flip(false, true);


        //Musica
        musicStart = Gdx.audio.newMusic(Gdx.files.internal("musica/start.mp3"));
        musicStart.setVolume(1f);
        musicStart.setLooping(true);

        musicEnd = Gdx.audio.newMusic(Gdx.files.internal("musica/end.mp3"));
        musicEnd.setVolume(1f);
        musicEnd.setLooping(true);


        soundMelee = Gdx.audio.newSound(Gdx.files.internal("musica/mele_attack.mp3"));
        soundMelee.setVolume(1, 0.8f);

        soundShoot = Gdx.audio.newSound(Gdx.files.internal("musica/shoot_robot_2.wav"));
        soundShoot.setVolume(2, 0.4f);

        soundTowerDead = Gdx.audio.newSound(Gdx.files.internal("musica/fireball.wav"));
        soundTowerDead.setVolume(3, 0.8f);

        soundWalk = Gdx.audio.newSound(Gdx.files.internal("musica/footstep.mp3"));
        soundWalk.setVolume(4, 0.8f);

        soundFire = Gdx.audio.newSound(Gdx.files.internal("musica/fuego_torre_2.wav"));
        soundFire.setVolume(5, 0.6f);

        soundThunder = Gdx.audio.newSound(Gdx.files.internal("musica/rayo_torre.wav"));
        soundThunder.setVolume(6, 0.6f);


        //Cargamos las texturas de las tropas, ponmeos animacion de caminando o atacando.
        TextureRegion[] regionCaballeroRun = TextureRegion.split(new Texture("tropas/knight_run.png"), 587, 707)[0];
        caballeroRun = new Animation(0.10f, regionCaballeroRun);
        caballeroRun.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] regionCaballeroAtaque = TextureRegion.split(new Texture("tropas/knight_attack.png"), 587, 707)[0];
        caballeroAttack = new Animation(0.10f, regionCaballeroAtaque);
        caballeroAttack.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] regionNinjaRun = TextureRegion.split(new Texture("tropas/ninja_run.png"), 363, 458)[0];
        ninjaRun = new Animation(0.10f, regionNinjaRun);
        ninjaRun.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] regionNinjaAtaque = TextureRegion.split(new Texture("tropas/ninja_attack.png"), 496, 458)[0];
        ninjaAttack = new Animation(0.10f, regionNinjaAtaque);
        ninjaAttack.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] regionRobotRun = TextureRegion.split(new Texture("tropas/robot_run.png"), 567, 556)[0];
        robotRun = new Animation(0.12f, regionRobotRun);
        robotRun.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] regionRobotAtaque = TextureRegion.split(new Texture("tropas/robot_shoot.png"), 567, 556)[0];
        robotAttack = new Animation(0.17f, regionRobotAtaque);
        robotAttack.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] regionRobotBullet = TextureRegion.split(new Texture("tropas/robot_bullet.png"), 172, 139)[0];
        robotBullet = new Animation(0.12f, regionRobotBullet);
        robotBullet.setPlayMode(Animation.PlayMode.LOOP);


        TextureRegion[] regionRobotMuzzle = TextureRegion.split(new Texture("tropas/robot_muzzle.png"), 19, 241)[0];
        robotMuzzle = new Animation(0.12f, regionRobotMuzzle);
        robotMuzzle.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] regionFuegoTorre = TextureRegion.split(new Texture("torres/fuego_torre_2.png"), 512, 512)[0];
        fuegoTorre = new Animation(0.15f, regionFuegoTorre);
        fuegoTorre.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] regionRayoTorre = TextureRegion.split(new Texture("torres/rayo_torre.png"), 192, 192)[0];
        rayoTorre = new Animation(0.15f, regionRayoTorre);
        rayoTorre.setPlayMode(Animation.PlayMode.LOOP);


        //Cargar el fichero de fuentes, para aplicar.
        FileHandle fontFile = Gdx.files.internal("fonts/fuente1.fnt");
        font = new BitmapFont(fontFile, true);
        font.getData().setScale(4f);

        //Fuentes Grande
        fontGrande = new BitmapFont(fontFile, true);
        fontGrande.getData().setScale(5f);

        //Fuente Pequeño
        fontPequenia = new BitmapFont(fontFile, true);
        fontPequenia.getData().setScale(2f);

        // Creamos l'estilo de l'etiquetas
        textStyle = new Label.LabelStyle(font, null);

        textStyleTitulo = new Label.LabelStyle(fontGrande, null);

        textStylePequenio = new Label.LabelStyle(fontPequenia, null);

        //Creamos la camara de dimensiones de juego.
        camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        //Pniendo un true po parametros, configuramos la camera para que haga servir el sistema de coordenades y-Down
        camera.setToOrtho(true);

        //Inicializamos el mapa donde se juega el juego.
        tiledMap1 = new TmxMapLoader().load("texturas/mapa1.tmx");

        tiledMap2 = new TmxMapLoader().load("texturas/mapa2.tmx");

    }

    /**
     * Methodo dispose
     */
    public static void dispose() {

        // Descartem els recursos
        fondo.dispose();
        musicStart.dispose();
        musicEnd.dispose();
        soundMelee.dispose();
        soundTowerDead.dispose();

    }

}

