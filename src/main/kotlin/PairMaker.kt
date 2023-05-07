import kotlin.random.Random

object PairMaker {
    fun makePairs(members: List<Person>): Map<Person, Person> {
        val p1ToP2 = mutableMapOf<Person, Person>()
        val list = members.toMutableList()
        var iter = 0
        while (list.size > 1) {
            val p1 = randomElementFromGivenList(list)
            val p2 = randomElementFromGivenList(list)
            // if cannot find match pair within 5 rounds, use the next match, the input source is not distributed evenly
            if ((p1.name != p2.name && p1.team != p2.team) || iter == 5) {
                p1ToP2[p1] = p2
                list.remove(p1)
                list.remove(p2)
                iter = 0
                continue
            }
            iter++

        }
        if (list.isNotEmpty()) {
            // if team member number is odd, the last member would be matched to manager
            p1ToP2[list[0]] = Person("Manager Name", "Manager Email", "Manager Team")
        }
        return p1ToP2
    }


    private fun randomElementFromGivenList(list: List<Person>): Person {
        val randomIndex = Random.nextInt(list.size)
        return list[randomIndex]
    }
}