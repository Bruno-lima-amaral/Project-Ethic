package br.com.bloodfoxdev.projetoetich

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bloodfoxdev.projetoetich.ui.theme.ProjetoEtichTheme
import android.widget.Toast.makeText as makeText1

class Activity2() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoEtichTheme {
                // A surface container using the 'background' color from the theme
                FormLogin()

            }
        }
    }

    @Preview
    @Composable
    private fun FormLogin() {
        val instagramState = remember { mutableStateOf("") }
        val whatsappState = remember { mutableStateOf("") }
        val facebookState = remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "Ethical Hacking",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 32.sp
                    )
                })
            },
            backgroundColor = Color.DarkGray,
        ) {
            Column(
                modifier = Modifier
                    //esse fillMaxSize serve para deixa o conteúdo em relação com a tela inteira do dispositivo.
                    //Que no caso o conteúdo em questão é essa Coluna em "Grid" entre aspas.
                    .fillMaxSize()
                    .padding(16.dp),
                //esses dois eu acredito é auto explicativo
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {




                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hacker),
                        contentDescription = "Hacker Img",
                        modifier = Modifier.fillMaxWidth()
                    )


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Digite seus Dados",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.heightIn(5.dp, 15.dp))
                        OutlinedTextField(
                            value = instagramState.value,
                            onValueChange = { textoRecebido ->
                                instagramState.value = textoRecebido
                            },
                            label = { Text(text = "Instagram", color = Color.White) })
                        Spacer(modifier = Modifier.heightIn(5.dp, 15.dp))
                        OutlinedTextField(
                            value = whatsappState.value,
                            onValueChange = { textoRecebido ->
                                whatsappState.value = textoRecebido
                            },
                            label = { Text(text = "Whatsapp", color = Color.White) })
                        Spacer(modifier = Modifier.heightIn(5.dp, 15.dp))
                        OutlinedTextField(
                            value = facebookState.value,
                            onValueChange = { textoRecebido ->
                                facebookState.value = textoRecebido
                            },
                            label = { Text(text = "Facebook", color = Color.White) })
                        Spacer(modifier = Modifier.heightIn(5.dp, 15.dp))
                        //aqui agora é para  colocar a ação de Trocar de Activity
                        //Aquele que tiver coragem tente kkkkk

                        val context = LocalContext.current

                        Button(onClick = {
                            Toast.makeText(
                                context,
                                "vc clickou em MIM!!",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)
                        }) {
                            Text(text = "Voltar")
                        }
                    }


                }
            }
        }
    }
}

