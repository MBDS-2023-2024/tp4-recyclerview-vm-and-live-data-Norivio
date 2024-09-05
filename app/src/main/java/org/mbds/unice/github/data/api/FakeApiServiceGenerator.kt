package org.mbds.unice.github.data.api

import org.mbds.unice.github.data.model.User
import java.time.LocalDate
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://avatar.iran.liara.run/public/47", true, LocalDate.of(2023, 1, 18)),
        User("002", "Paul", "https://avatar.iran.liara.run/public/18", true, LocalDate.of(2023, 1, 18)),
        User("003", "Phil", "https://avatar.iran.liara.run/public/39", true, LocalDate.of(2023, 1, 18)),
        User("004", "Guillaume", "https://avatar.iran.liara.run/public/1", true, LocalDate.of(2023, 1, 18)),
        User("005", "Francis", "https://avatar.iran.liara.run/public/50", true, LocalDate.of(2023, 1, 18)),
        User("006", "George", "https://avatar.iran.liara.run/public/32", true, LocalDate.of(2023, 2, 20)),
        User("007", "Louis", "https://avatar.iran.liara.run/public/26", true, LocalDate.of(2023, 2, 20)),
        User("008", "Mateo", "https://avatar.iran.liara.run/public/4", true, LocalDate.of(2023, 2, 20)),
        User("009", "April", "https://avatar.iran.liara.run/public/44", true, LocalDate.of(2023, 3, 25)),
        User("010", "Louise", "https://avatar.iran.liara.run/public/61", true, LocalDate.of(2023, 3, 25)),
        User("011", "Elodie", "https://avatar.iran.liara.run/public/53", true, LocalDate.of(2023, 3, 25)),
        User("012", "Helene", "https://avatar.iran.liara.run/public/54", true, LocalDate.of(2023, 3, 25)),
        User("013", "Fanny", "https://avatar.iran.liara.run/public/62", true, LocalDate.of(2024, 1, 28)),
        User("014", "Laura", "https://avatar.iran.liara.run/public/76", true, LocalDate.of(2024, 1, 28)),
        User("015", "Gertrude", "https://avatar.iran.liara.run/public/100", true, LocalDate.of(2024, 1, 28)),
        User("016", "Chloé", "https://avatar.iran.liara.run/public/96", true, LocalDate.of(2024, 1, 28)),
        User("017", "April", "https://avatar.iran.liara.run/public/22", true, LocalDate.of(2024, 4, 10)),
        User("018", "Marie", "https://avatar.iran.liara.run/public/85", true, LocalDate.of(2024, 4, 10)),
        User("019", "Henri", "https://avatar.iran.liara.run/public/28", true, LocalDate.of(2024, 4, 10)),
        User("020", "Rémi", "https://avatar.iran.liara.run/public/5", true, LocalDate.of(2024, 4, 10))
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://avatar.iran.liara.run/public/74", true, LocalDate.of(2024, 5, 15)),
        User("022", "Geoffrey", "https://avatar.iran.liara.run/public/48", true, LocalDate.of(2024, 5, 15)),
        User("023", "Simon", "https://avatar.iran.liara.run/public/18", true, LocalDate.of(2024, 5, 15)),
        User("024", "André", "https://avatar.iran.liara.run/public/2", true, LocalDate.of(2024, 5, 15)),
        User("025", "Leopold", "https://avatar.iran.liara.run/public/36", true, LocalDate.of(2024, 5, 15))
    )
}