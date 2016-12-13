package com.appspot.pistatium.dotsubscribe.models

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Article(var title: String = "", var url: String = "")
