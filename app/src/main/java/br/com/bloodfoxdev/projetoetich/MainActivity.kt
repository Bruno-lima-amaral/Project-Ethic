package br.com.bloodfoxdev.projetoetich

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bloodfoxdev.projetoetich.ui.theme.ProjetoEtichTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoEtichTheme {
                // A surface container using the 'background' color from the theme
                FormaLogin()
//                Greeting (onClick = {
//                    // this here is MainActivity
//
//                    startDetailActivity()
//                })

            }
        }
    }

//    fun startDetailActivity() {
//        val intent = Intent(this, Activity2::class.java)
//        startActivity(intent)
//    }
//    @Composable
//
//    fun Greeting(onClick: () -> Unit) {
//
//        Button(onClick = onClick) {
//            Text(text = "Button")
//        }
//    }
    @Preview
    @Composable
    private fun FormaLogin() {
        val nameState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }

        // Função Privada que contém o Conteúdo

        Scaffold(  //explicando do meu jeito, SCAFFOLD é um Body em que se pode colocar vário atributos

            //Aqui eu coloquei o "Header" do meu App e a cor de Fundo
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "Ethical Hacking",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 32.sp
                    )
                })
            },
            backgroundColor = Color.DarkGray

        ) {
            //Aqui pelo que eu entendi no vídeo, seria tipo a definição do display
            Column(
                modifier = Modifier
                    //esse fillMaxSize serve para deixa o conteúdo em relação com a tela inteira do dispositivo.
                    //Que no caso o conteúdo em questão é essa Coluna em "Grid" entre aspas.
                    .fillMaxSize()
                    .padding(16.dp),
                //esses dois eu acredito é auto explicativo
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                //E todas essas linhas também são auto explicaticas
                Text(
                    text = "Logue-se",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White
                )
                OutlinedTextField(
                    value = nameState.value,
                    onValueChange = { textoRecebido -> nameState.value = textoRecebido },
                    label = { Text(text = "Usuário", color = Color.White) })
                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = { textoRecebido -> passwordState.value = textoRecebido },
                    label = { Text(text = "Senha", color = Color.White) })

                //aqui agora é para  colocar a ação de Trocar de Activity
                //Aquele que tiver coragem tente kkkkk

                val context = LocalContext.current

                Button(onClick = {
                    val intent = Intent(context, Activity2::class.java)
                    context.startActivity(intent)
                }) {
                    Text(text = "Login")
                }
            }
        }

    }


}