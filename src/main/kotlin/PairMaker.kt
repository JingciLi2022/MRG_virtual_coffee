import kotlin.random.Random

object PairMaker {
    fun makePairs(members: List<Person>, blackList: Set<Pair<String, String>>): Map<Person, Person> {
        val p1ToP2 = mutableMapOf<Person, Person>()
        val list = members.toMutableList()
        var iter = 0
        while (list.size > 1) {
            val p1 = randomElementFromGivenList(list)
            val p2 = randomElementFromGivenList(list)
            // if cannot find match pair within 10 rounds, use the next match, the input source is not distributed evenly
            if (isPairValid(p1, p2, blackList) || iter == 10) {
                if (iter == 10) {
                    println("This is a biased match, consider rerun the project or check the input file")
                }
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

    private fun isPairValid(person1: Person, person2: Person, blackList: Set<Pair<String, String>>): Boolean {
        return person1.team != person2.team && person1.email != person2.email && !isPairInBlackList(person1.email, person2.email, blackList)
    }

    private fun isPairInBlackList(email1: String, email2: String, blackList: Set<Pair<String, String>>): Boolean {
        return blackList.contains(Pair(email1, email2)) || blackList.contains(Pair(email2, email1))
    }

    private fun randomElementFromGivenList(list: List<Person>): Person {
        val randomIndex = Random.nextInt(list.size)
        return list[randomIndex]
    }
}