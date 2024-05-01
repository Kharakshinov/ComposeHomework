package ru.project.composehomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactDetails(
                contact = Contact(
                    name = "Евгений",
                    surname = "Андреевич",
                    familyName = "Лукашин",
                    phone = "+ 7 495 495 95 95",
                    email = "ELukashin@practicum.ru",
                    address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                    imageRes = null,
                    isFavorite = true,
                )
            )
        }
    }

    @Composable
    fun ContactDetails(contact: Contact) {
        ShowContactDetails(contact)
    }

    @Preview(showSystemUi = true)
    @Composable
    fun ContactDetailsOne() {
        ShowContactDetails(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                phone = "+ 7 495 495 95 95",
                email = "ELukashin@practicum.ru",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                imageRes = null,
                isFavorite = true,
            )
        )
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun ContactDetailsTwo() {
        val contactTwo = Contact(
            name = "Василий",
            surname = null,
            familyName = "Кузякин",
            phone = null,
            email = null,
            address = "Ивановская область, дер. Крутово, д. 4",
            imageRes = R.drawable.shrek,
            isFavorite = false,
        )
        ShowContactDetails(contactTwo)
    }

    @Composable
    private fun ShowContactDetails(contact: Contact) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShowContactPhoto(contact)
            ShowNameAndSurname(contact)
            ShowFamilyNameAndStar(contact)
            InfoRow(stringResource(id = R.string.phone), contact.phone ?: "...")
            InfoRow(stringResource(id = R.string.address), contact.address)
            InfoRow(stringResource(id = R.string.email), contact.email)
        }
    }

    @Composable
    private fun ShowContactPhoto(contact: Contact) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(50.dp, 50.dp),
            contentAlignment = Alignment.Center
        ) {
            if (contact.imageRes != null) {
                Image(
                    painter = painterResource(id = R.drawable.shrek),
                    contentDescription = null,
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.LightGray)
                )
                Text("${contact.name.take(1)}${contact.familyName.take(1)}")
            }
        }
    }

    @Composable
    private fun ShowNameAndSurname(contact: Contact) {
        val nameAndSurname: String = if (contact.surname != null) {
            "${contact.name} ${contact.surname}"
        } else {
            contact.name
        }
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = nameAndSurname,
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
    }

    @Composable
    private fun ShowFamilyNameAndStar(contact: Contact) {
        Row {
            Text(
                text = contact.familyName,
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            if (contact.isFavorite) {
                Image(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = null,
                )
            }
        }
    }

    @Composable
    private fun InfoRow(template: String, data: String?) {
        Row {
            if (data != null) {
                Text(
                    text = template,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 8.dp, top = 16.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                    ),
                    textAlign = TextAlign.End
                )
                Text(
                    text = data,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(top = 16.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                    )
                )
            }
        }
    }
}