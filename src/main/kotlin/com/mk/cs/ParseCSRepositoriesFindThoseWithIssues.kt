package com.mk.cs

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import khttp.get
import khttp.structures.authorization.BasicAuthorization
import java.io.File
import java.io.FileReader
import java.io.StringReader

class ParseCSRepositoriesFindThoseWithIssues {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            var a: JsonArray<JsonObject> = Klaxon().parseJsonArray(FileReader(File("src/main/resources/repos_with_issue_url.json"))) as JsonArray<JsonObject>

            a.forEach { it ->
                val url = it.get("issues_url").toString().dropLast(9)
                val response = get(url,auth=BasicAuthorization("gorgx0","github_access_token"))
                val issues = Klaxon().parseJsonArray(StringReader(String(response.content)))
                val size = issues.size
                if(size>0){
                    println(it.get("name"))
                }
            }
        }
    }
}


