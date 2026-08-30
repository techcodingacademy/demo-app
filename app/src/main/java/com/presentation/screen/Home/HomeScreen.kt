package com.presentation.screen.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AddToHomeScreen
import androidx.compose.material.icons.automirrored.filled.Announcement
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.LiveHelp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.domain.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    //HomeScreen Received uiState and onUserClick lambda
    uiState: HomeUiState,
    onUserClick: (User) -> Unit
) {
    when (uiState) {
        is HomeUiState.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier.padding(16.dp)
            )
        }

        is HomeUiState.Success -> {
            //Text(text = "Count: ${uiState.users.size}")
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("Dashboard",style = MaterialTheme.typography.titleMedium)
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                bottomBar = {
                    NavigationBar {
                        NavigationBarItem(
                            selected = true,
                            onClick = {

                            },
                            modifier = Modifier.background(
                                color = Color.LightGray
                            ),
                            icon = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.AddToHomeScreen,
                                    contentDescription = "Home"
                                )
                            },
                            label = { Text(text = "Home",style = MaterialTheme.typography.bodySmall) }
                        )
                        NavigationBarItem(
                            selected = true,
                            onClick = {},
                            modifier = Modifier.background(
                                color = Color.LightGray
                            ),
                            icon = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.Chat,
                                    contentDescription = "Chat"
                                )
                            },
                            label = { Text(text = "Chat",style = MaterialTheme.typography.bodySmall) }
                        )
                        NavigationBarItem(
                            selected = true,
                            onClick = {},
                            modifier = Modifier.background(
                                color = Color.LightGray
                            ),
                            icon = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.Announcement,
                                    contentDescription = "Announcement"
                                )
                            },
                            label = {
                                Text(text = "Announcement",style = MaterialTheme.typography.bodySmall)
                            }
                        )
                        NavigationBarItem(
                            selected = true,
                            onClick = {},
                            modifier = Modifier.background(
                                color = Color.LightGray
                            ),
                            icon = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.LiveHelp,
                                    contentDescription = "Live Help"
                                )
                            },
                            label = { Text(
                                text = "Live Help",
                                style = MaterialTheme.typography.bodySmall
                            ) }
                        )
                    }
                }
            ) { innerPadding ->
                LazyColumn(
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.background
                    ),
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.users) { user ->

                        CardScreen(
                            user = user,
                            onUserClick = onUserClick
                        )
                    }
                }
            }
        }
        is HomeUiState.Error -> {
            Text(text = uiState.message)
        }
    }
}

@Composable
fun CardScreen(
    user: User,
    onUserClick: (User) -> Unit
) {
    Card(
        onClick = { onUserClick(user) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray),

        ) {
        Row {
            AsyncImage(
                model = user.image,
                contentDescription = "User image",
                modifier = Modifier.size(50.dp)
            )
            Column(modifier = Modifier.padding(all = 18.dp)) {
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    style = MaterialTheme.typography.titleMedium
                )

            }
        }
    }
}