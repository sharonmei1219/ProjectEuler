from Ranking import RuleFactory

class PokerHand(object):
    def __init__(self):
        rules = RuleFactory()
        self.prioritedRankings = [rules.straightFlush(),
                              rules.fourOfAKind(),
                              rules.fullHouse(),
                              rules.flush(),
                              rules.straight(),
                              rules.threeOfAKind(),
                              rules.twoPairs(),
                              rules.onePair(),
                              rules.highCards()]
    
    def compareHand(self, hand1, hand2):
        for rule in self.prioritedRankings:
            compareResult = rule.sort(hand1).__cmp__(rule.sort(hand2))
            if compareResult != 0:
                return compareResult
        return 0