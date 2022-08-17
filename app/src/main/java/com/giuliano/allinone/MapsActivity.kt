package com.giuliano.allinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.giuliano.allinone.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

data class Place(
    val name: String,
    val latLng: LatLng,
    val address: String,
    val rating: Float
)

class MapsActivity : AppCompatActivity() {

    private  val binding: ActivityMapsBinding by lazy {
        ActivityMapsBinding.inflate(layoutInflater)
    }

    // Criamos um array de Places

    private val places = arrayListOf(Place("FIAP Campus Vila Olimpia", LatLng(-23.5955843, -46.6851937), "Rua Olimpiadas, 186 - São Paulo - SP", 4.8f),
        Place("FIAP Campus Paulista", LatLng(-23.5643721, -46.652857), "Av. Paulista, 1106 - São Paulo - SP", 5.0f),
        Place("FIAP Campus Vila Mariana", LatLng(-23.5746685, -46.6232043), "Av. Lins de Vasconcelos, 1264 - São Paulo - SP", 4.8f)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // Aqui localizamos o fragment no XML como um SupportMapFragment
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync{
            // Adicionamos Markers no Mapa
            googleMap -> addMarkers(googleMap)

            // criamos um bound que cria uma area para podermos mover com a camera até o local onde estão os markers
            googleMap.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()
                places.forEach {
                    bounds.include(it.latLng)
                }
                // Movemos a camera para os bounds criados
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100))
            }
        }

    }

    // Criamos uma função que adiciona um Marker no mapa
    private fun addMarkers(googleMap: GoogleMap) {
        places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .position(place.latLng)
                    .icon(BitMapHelper.vectorToBitmap(
                        this, R.drawable.ic_college_pin,
                        ContextCompat.getColor(this, R.color.black)
                    ))
            )

        }
    }
}