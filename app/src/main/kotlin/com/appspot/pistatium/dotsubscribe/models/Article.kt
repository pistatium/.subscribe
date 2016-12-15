package com.appspot.pistatium.dotsubscribe.models

import com.google.firebase.database.*
import rx.Observable


@IgnoreExtraProperties
data class Article(var title: String = "", var url: String = "")


class ArticleModel() {
    fun getLatest() : Observable<List<Article>> = Observable.create<List<Article>> { subscriber ->
        val database = FirebaseDatabase.getInstance()
        // TODO:
        val today = "20161210"
        val current = "173000"
        val latest_news = database.reference.child(today).child(current)
        latest_news.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val articles = snapshot.children
                        .map { it.getValue(Article::class.java) }
                subscriber.onNext(articles)
                subscriber.onCompleted()
            }
            override fun onCancelled(p0: DatabaseError?) { }
        })
    }
}