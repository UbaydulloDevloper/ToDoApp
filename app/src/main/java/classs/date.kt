package classs

import adapters.DateLevel


class date {
    var name: String = ""
    var description: String = ""
    var create_date: String = ""
    var dedline: String = ""
    var degree: DateLevel? = null
    var sorting: String = ""


    constructor()
    constructor(
        name: String,
        description: String,
        create_date: String,
        dedline: String,
        degree: DateLevel,
        sorting: String
    ) {
        this.name = name
        this.description = description
        this.create_date = create_date
        this.dedline = dedline
        this.degree = degree
        this.sorting = sorting

    }


}