/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.UsuarioLog;
import logica.media.Episodio;
import logica.media.Musica;
import logica.media.Pelicula;
import logica.media.Serie;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class GestionMultimediaController implements Initializable {

    @FXML
    private Label labelNombreUsuario;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonRetroceso;
    @FXML
    private ImageView imagenRetroceso;
    @FXML
    private Button botonAgregarMedio;
    @FXML
    private Button botonEditarMedio;
    @FXML
    private Button botonEliminarMedio;
    @FXML
    private TableView<Pelicula> tablaPeliculas;
    @FXML
    private TableColumn<?, ?> colTituloPelicula;
    @FXML
    private TableColumn<?, ?> colGeneroPelicula;
    @FXML
    private TableColumn<?, ?> colFechaPelicula;
    @FXML
    private TableColumn<?, ?> colReproduccionesPelicula;
    @FXML
    private TableColumn<?, ?> colDescripcionPelicula;

    @FXML
    private TableView<Musica> tablaMusica;
    @FXML
    private TableView<Serie> tablaSeries;

    FXMLLoader loaderEmergente;

    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    private Button heredado;

    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";

    private final String multimedia[] = {"Peliculas", "Musica", "Series"};

    private ObservableList<String> itemsBox;
    private ObservableList<Pelicula> peliculas;
    private ObservableList<Musica> musicas;
    private ObservableList<Serie> series;
    private ObservableList<Episodio> episodios;

    private ArrayList arrayListPeliculas;
    private ArrayList arrayListMusica;
    private ArrayList arrayListSerie;

    @FXML
    private TabPane PanelTab;
    @FXML
    private Tab tabPelicula;
    @FXML
    private Tab tabMusica;
    @FXML
    private Tab tabSeries;

    private Pelicula peliculaSeleccionada;
    private Musica musicaSeleccionada;
    private Episodio episodioSeleccionado;
    private Serie serieSeleccionada;

    @FXML
    private TableColumn<?, ?> colTituloMusica;
    @FXML
    private TableColumn<?, ?> colFechaMusica;
    @FXML
    private TableColumn<?, ?> colGeneroMusica;
    @FXML
    private TableColumn<?, ?> colAlbumMusica;
    @FXML
    private TableColumn<?, ?> colArtistaMusica;
    @FXML
    private TableColumn<?, ?> colReproduccionesMusica;
    @FXML
    private TableView<Episodio> tablaEpisodios;
    @FXML
    private TableColumn<?, ?> colTituloEpisodio;
    @FXML
    private TableColumn<?, ?> colNumeroEpisodio;
    @FXML
    private TableColumn<?, ?> colFechaEpisodio;
    @FXML
    private TableColumn<?, ?> colReproduccionesEpisodio;
    @FXML
    private TableColumn<?, ?> colTituloSerie;
    @FXML
    private TableColumn<?, ?> colGeneroSerie;
    @FXML
    private TableColumn<?, ?> colFechaSerie;
    @FXML
    private TableColumn<?, ?> colReproduccionesSerie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        peliculas = FXCollections.observableArrayList();
        musicas = FXCollections.observableArrayList();
        series = FXCollections.observableArrayList();
        episodios = FXCollections.observableArrayList();

        //Tabla peliculas
        this.colTituloPelicula.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.colGeneroPelicula.setCellValueFactory(new PropertyValueFactory("genero"));
        this.colFechaPelicula.setCellValueFactory(new PropertyValueFactory("fechaString"));
        this.colReproduccionesPelicula.setCellValueFactory(new PropertyValueFactory("reproducciones"));
        this.colDescripcionPelicula.setCellValueFactory(new PropertyValueFactory("descripcion"));

        //Tabla musica
        this.colTituloMusica.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.colGeneroMusica.setCellValueFactory(new PropertyValueFactory("genero"));
        this.colFechaMusica.setCellValueFactory(new PropertyValueFactory("fechaString"));
        this.colArtistaMusica.setCellValueFactory(new PropertyValueFactory("artista"));
        this.colAlbumMusica.setCellValueFactory(new PropertyValueFactory("album"));
        this.colReproduccionesMusica.setCellValueFactory(new PropertyValueFactory("reproducciones"));

        //Tabla series
        this.colTituloSerie.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.colGeneroSerie.setCellValueFactory(new PropertyValueFactory("genero"));
        this.colFechaSerie.setCellValueFactory(new PropertyValueFactory("fechaString"));
        this.colReproduccionesSerie.setCellValueFactory(new PropertyValueFactory("reproducciones"));

        //Tabla episodios
        this.colTituloEpisodio.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.colNumeroEpisodio.setCellValueFactory(new PropertyValueFactory("numEpisodio"));
        this.colFechaEpisodio.setCellValueFactory(new PropertyValueFactory("fechaString"));
        this.colReproduccionesEpisodio.setCellValueFactory(new PropertyValueFactory("reproducciones"));

    }

    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada) {

        this.gestorDatos = gestorDatos;
        this.logDatos = logDatos;
        setImagenUsuario();
        this.heredado = elementoVentanaHeredada;

        castArrayAObservablePelicula();
        castArrayAObservableMusica();
        castArrayAObservableSeries();

        tablaPeliculas.setItems(peliculas);
        tablaPeliculas.refresh();

        tablaMusica.setItems(musicas);
        tablaMusica.refresh();

        tablaSeries.setItems(series);
        tablaSeries.refresh();

    }

    public void setImagenUsuario() {
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText(this.logDatos.getCuentaActiva().getNombre());
    }

    @FXML
    private void fueraBotonRetroceso(MouseEvent event) {
        imagenRetroceso.setImage(new Image("file:src/recursos/Imagenes/Iconos/back-arrow.png"));
    }

    @FXML
    private void sobreBotonRetroceso(MouseEvent event) {
        imagenRetroceso.setImage(new Image("file:src/recursos/Imagenes/Iconos/back-arrow-orange.png"));
    }

    @FXML
    private void retroceder(ActionEvent event) {
        Stage stageGestionMultimedia = (Stage) this.botonRetroceso.getScene().getWindow();
        stageGestionMultimedia.close();
        Stage retorno = (Stage) this.heredado.getScene().getWindow();
        retorno.show();
    }

    @FXML
    private void fueraBotonAgregar(MouseEvent event) {
        botonAgregarMedio.setStyle(colorFuera);
    }

    @FXML
    private void sobreBotonAgregar(MouseEvent event) {
        botonAgregarMedio.setStyle(colorSobre);
    }

    @FXML
    private void agregarMedio(ActionEvent event) {
        if (tabPelicula.isSelected()) {
            cargaAgregarPelicula();
        } else if (tabMusica.isSelected()) {
            cargaAgregarMusica();
        } else if (tabSeries.isSelected()) {
            cargaAgregarSerieEpisodio();
        }

    }

    private void cargaAgregarPelicula() {
        try {
            loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/AgregarPelicula.fxml"));

            Parent raiz = loaderEmergente.load();

            AgregarPeliculaController controlador = loaderEmergente.getController();

            Scene escena = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Agregar Pelicula");
            stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
            stage.setScene(escena);

            stage.showAndWait();

            Pelicula peliculaAgregada = controlador.getPeliculaAgregada();
            if (peliculaAgregada != null) {
                peliculas.add(peliculaAgregada);
                tablaPeliculas.refresh();
                actualizarBaseDatosPeliculas();
            }
        } catch (IOException e) {
        }
    }

    private void cargaAgregarMusica() {
        try {
            loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/AgregarMusica.fxml"));

            Parent raiz = loaderEmergente.load();

            AgregarMusicaController controlador = loaderEmergente.getController();

            Scene escena = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Agregar Musica");
            stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
            stage.setScene(escena);

            stage.showAndWait();

            Musica musicaAgregada = controlador.getMusicaAgregada();
            if (musicaAgregada != null) {
                musicas.add(musicaAgregada);
                tablaMusica.refresh();
                actualizarBaseDatosMusica();
            }
        } catch (IOException e) {
        }
    }

    private void cargaAgregarSerieEpisodio() {
        try {
            loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/AgregarSerie.fxml"));

            Parent raiz = loaderEmergente.load();

            AgregarSerieController controlador = loaderEmergente.getController();
            controlador.iniciarAtributos(series);

            Scene escena = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Agregar Serie");
            stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
            stage.setScene(escena);

            stage.showAndWait();

            Episodio episodioAgregado = controlador.getEpisodioAgregado();
            Serie serieRelacionada = controlador.getSerieRelacionada();
            if (episodioAgregado != null && serieRelacionada != null) {
                if (series.contains(serieRelacionada)) {
                    for (int i = 0; i < series.size(); i++) {
                        if (series.get(i).equals(serieRelacionada)) {
                            series.get(i).getEpisodios().add(episodioAgregado);
                            break;
                        }
                    }
                } else {
                    serieRelacionada.getEpisodios().add(episodioAgregado);
                    series.add(serieRelacionada);
                }
                tablaSeries.refresh();
                actualizarBaseDatosSeries();
            }
        } catch (IOException e) {
        }
    }

    @FXML
    private void fueraBotonEditar(MouseEvent event) {
        botonEditarMedio.setStyle(colorFuera);
    }

    @FXML
    private void sobreBotonEditar(MouseEvent event) {
        botonEditarMedio.setStyle(colorSobre);
    }

    @FXML
    private void editarMedio(ActionEvent event) {
        if (tabPelicula.isSelected()) {
            cargaEditarPelicula();
        } else if (tabMusica.isSelected()) {
            cargaEditarMusica();
        } else if (tabSeries.isSelected()) {
            cargaEditarSerieEpisodio();
        }

    }

    private void cargaEditarPelicula() {
        if (this.peliculaSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a editar");
            alert.showAndWait();
        } else {
            try {
                loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/EditarPelicula.fxml"));

                Parent raiz = loaderEmergente.load();

                EditarPeliculaController controlador = loaderEmergente.getController();
                controlador.iniciarAtributos(this.peliculaSeleccionada);

                Scene escena = new Scene(raiz);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setTitle("Editar Pelicula");
                stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                stage.setScene(escena);

                stage.showAndWait();

                Pelicula peliculaModificada = controlador.getPeliculaModificada();
                if (peliculaModificada != null) {
                    this.peliculas.remove(this.peliculaSeleccionada);
                    peliculas.add(peliculaModificada);
                    tablaPeliculas.refresh();
                    actualizarBaseDatosPeliculas();
                }
            } catch (IOException e) {
            }

        }

    }

    private void cargaEditarMusica() {
        if (this.musicaSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a editar");
            alert.showAndWait();
        } else {
            try {
                loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/EditarMusica.fxml"));

                Parent raiz = loaderEmergente.load();

                EditarMusicaController controlador = loaderEmergente.getController();
                controlador.iniciarAtributos(this.musicaSeleccionada);

                Scene escena = new Scene(raiz);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setTitle("Editar Musica");
                stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                stage.setScene(escena);

                stage.showAndWait();

                Musica musicaModificada = controlador.getMusicaModificada();
                if (musicaModificada != null) {
                    this.musicas.remove(this.musicaSeleccionada);
                    musicas.add(musicaModificada);
                    tablaMusica.refresh();
                    actualizarBaseDatosMusica();
                }
            } catch (IOException e) {
            }

        }

    }

    private void cargaEditarSerieEpisodio() {
        if (this.serieSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a editar");
            alert.showAndWait();
        } else {
            if (this.episodioSeleccionado == null) {
                try {
                    loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/EditarSerie.fxml"));

                    Parent raiz = loaderEmergente.load();

                    EditarSerieController controlador = loaderEmergente.getController();
                    controlador.iniciarAtributos(serieSeleccionada);

                    Scene escena = new Scene(raiz);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.setTitle("Editar Serie");
                    stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                    stage.setScene(escena);

                    stage.showAndWait();

                    Serie serieModificada = controlador.getSerieModificada();
                    if (serieModificada != null) {
                        this.series.remove(this.serieSeleccionada);
                        series.add(serieModificada);
                        tablaSeries.refresh();
                        actualizarBaseDatosSeries();
                    }

                } catch (IOException e) {
                }
            } else {
                try {
                    loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/emergente.fxml"));

                    Parent raiz = loaderEmergente.load();

                    EmergenteController controlador = loaderEmergente.getController();
                    controlador.iniciarAtributos(1, serieSeleccionada, episodioSeleccionado);

                    Scene escena = new Scene(raiz);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.setTitle("Seleccionar Opcion");
                    stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                    stage.setScene(escena);

                    stage.showAndWait();

                    if (controlador.getOpcion() == 1) {
                        Serie serieModificada = controlador.getSerieModificada();
                        if (serieModificada != null) {
                            this.series.remove(this.serieSeleccionada);
                            series.add(serieModificada);
                            tablaSeries.refresh();
                            actualizarBaseDatosSeries();
                        }
                    } else if (controlador.getOpcion() == 2) {
                        Serie serieEpisodioModificado = controlador.getEpisodioModificado();
                        if (serieEpisodioModificado != null) {
                            this.series.remove(this.serieSeleccionada);
                            series.add(serieEpisodioModificado);
                            tablaSeries.refresh();

                            this.episodios = null;
                            this.episodios = FXCollections.observableArrayList();
                            castArrayAObservableEpisodios(serieEpisodioModificado.getEpisodios());
                            this.tablaEpisodios.setItems(episodios);
                            this.tablaEpisodios.refresh();

                            actualizarBaseDatosSeries();

                        }
                    }

                } catch (IOException e) {
                }
            }

        }

    }

    @FXML
    private void fueraBotonEliminar(MouseEvent event) {
        botonEliminarMedio.setStyle(colorFuera);
    }

    @FXML
    private void sobreBotonEliminar(MouseEvent event) {
        botonEliminarMedio.setStyle(colorSobre);
    }

    @FXML
    private void eliminarMedio(ActionEvent event) {
        if (tabPelicula.isSelected()) {
            cargaEliminarPelicula();
        } else if (tabMusica.isSelected()) {
            cargaEliminarMusica();
        } else if (tabSeries.isSelected()) {
            cargaEliminarSerieEpisodio();
        }
    }

    private void cargaEliminarPelicula() {
        if (peliculaSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a Eliminar");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Se eliminará el elemento seleccionado");
            alert.showAndWait();

            this.peliculas.remove(this.peliculaSeleccionada);
            this.tablaPeliculas.refresh();
            actualizarBaseDatosPeliculas();
            this.peliculaSeleccionada = null;
        }
    }

    private void cargaEliminarMusica() {
        if (musicaSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a Eliminar");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Se eliminará el elemento seleccionado");
            alert.showAndWait();

            this.musicas.remove(this.musicaSeleccionada);
            this.tablaMusica.refresh();
            actualizarBaseDatosMusica();
            this.musicaSeleccionada = null;
        }
    }

    private void cargaEliminarSerieEpisodio() {

        if (this.serieSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a eliminar");
            alert.showAndWait();
        } else {
            if (this.episodioSeleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Se eliminará la serie seleccionada");
                alert.showAndWait();

                this.series.remove(this.serieSeleccionada);
                this.tablaSeries.refresh();
                this.episodios = null;
                this.tablaEpisodios.setItems(episodios);
                this.tablaEpisodios.refresh();
                
                actualizarBaseDatosSeries();
                this.serieSeleccionada = null;

            } else {
                try {
                    loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/emergente.fxml"));

                    Parent raiz = loaderEmergente.load();

                    EmergenteController controlador = loaderEmergente.getController();
                    controlador.iniciarAtributos(2, serieSeleccionada, episodioSeleccionado);

                    Scene escena = new Scene(raiz);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.setTitle("Seleccionar Opcion");
                    stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                    stage.setScene(escena);

                    stage.showAndWait();

                    if (controlador.getOpcion() == -1) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Se eliminará la serie seleccionada");
                        alert.showAndWait();

                        this.series.remove(this.serieSeleccionada);
                        this.tablaSeries.refresh();
                        this.episodios = null;
                        this.tablaEpisodios.setItems(episodios);
                        this.tablaEpisodios.refresh();
                        
                        actualizarBaseDatosSeries();
                        this.serieSeleccionada = null;

                    } else if (controlador.getOpcion() == -2) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Información");
                        alert.setContentText("Se eliminará el episodio seleccionado");
                        alert.showAndWait();
                        
                        this.serieSeleccionada.getEpisodios().remove(this.episodioSeleccionado);
                        this.episodioSeleccionado = null;
                        if (serieSeleccionada != null) {
                            this.episodios = null;
                            this.episodios = FXCollections.observableArrayList();
                            castArrayAObservableEpisodios(this.serieSeleccionada.getEpisodios());
                            this.tablaEpisodios.setItems(episodios);
                            this.tablaEpisodios.refresh();
                            
                            actualizarBaseDatosSeries();
                        }
                    }

                } catch (IOException e) {
                }
            }

        }

    }

    private void castArrayAObservablePelicula() {
        System.out.println(this.gestorDatos.getPeliculas().size());
        for (int i = 0; i < this.gestorDatos.getPeliculas().size(); i++) {
            this.peliculas.add(this.gestorDatos.getPeliculas().get(i));
        }
    }

    private void castArrayAObservableMusica() {
        for (int i = 0; i < this.gestorDatos.getMusica().size(); i++) {
            this.musicas.add(this.gestorDatos.getMusica().get(i));
        }
    }

    private void castObservableAArrayPelicula() {
        arrayListPeliculas = new ArrayList<>();
        for (int i = 0; i < this.peliculas.size(); i++) {
            arrayListPeliculas.add(this.peliculas.get(i));
        }
    }

    private void castObservableAArrayMusica() {
        arrayListMusica = new ArrayList<>();
        for (int i = 0; i < this.musicas.size(); i++) {
            arrayListMusica.add(this.musicas.get(i));
        }
    }

    private void castArrayAObservableSeries() {
        for (int i = 0; i < this.gestorDatos.getSeries().size(); i++) {
            this.series.add(this.gestorDatos.getSeries().get(i));
        }
    }

    private void castObservableAArraySeries() {
        arrayListSerie = new ArrayList<>();
        for (int i = 0; i < this.series.size(); i++) {
            arrayListSerie.add(this.series.get(i));
        }
    }

    private void castArrayAObservableEpisodios(ArrayList<Episodio> episodios) {
        for (int i = 0; i < episodios.size(); i++) {
            this.episodios.add(episodios.get(i));
        }
    }

    @FXML
    private void seleccionPelicula(MouseEvent event) {
        this.peliculaSeleccionada = tablaPeliculas.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void seleccionMusica(MouseEvent event) {
        this.musicaSeleccionada = tablaMusica.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void seleccionTabPelicula(Event event) {
    }

    @FXML
    private void seleccionTabMusica(Event event) {
    }

    @FXML
    private void seleccionTabSeries(Event event) {
    }

    private void actualizarBaseDatosPeliculas() {
        castObservableAArrayPelicula();
        this.gestorDatos.setPeliculas(arrayListPeliculas);
        this.gestorDatos.almacenarMultimedia();
    }

    private void actualizarBaseDatosMusica() {
        castObservableAArrayMusica();
        this.gestorDatos.setMusica(arrayListMusica);
        this.gestorDatos.almacenarMultimedia();
    }

    private void actualizarBaseDatosSeries() {
        castObservableAArraySeries();
        this.gestorDatos.setSeries(arrayListSerie);
        this.gestorDatos.almacenarMultimedia();
    }

    @FXML
    private void seleccionEpisodio(MouseEvent event) {
        this.episodioSeleccionado = this.tablaEpisodios.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void seleccionSerie(MouseEvent event) {
        this.serieSeleccionada = this.tablaSeries.getSelectionModel().getSelectedItem();
        this.episodioSeleccionado = null;
        if (serieSeleccionada != null) {
            this.episodios = null;
            this.episodios = FXCollections.observableArrayList();
            castArrayAObservableEpisodios(this.serieSeleccionada.getEpisodios());
            this.tablaEpisodios.setItems(episodios);
            this.tablaEpisodios.refresh();
        }

    }

}
