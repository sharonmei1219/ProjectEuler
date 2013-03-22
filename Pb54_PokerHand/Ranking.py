from Hand import NullHand
from Hand import Hand

class RuleFactory:
    def straight(self):
        return Sorter(5, CardsInSequence())
    
    def flush(self):
        return Sorter(5, CardsInSameSuit())
        
    def highCards(self):
        return Sorter(5, NullChecking())
    
    def fourOfAKind(self):
        return Sorter(4, CardsWithSameValue())
    
    def threeOfAKind(self):
        return Sorter(3, CardsWithSameValue())
    
    def twoPairs(self):
        return ComposedSorter([Sorter(2, CardsWithSameValue()), Sorter(2, CardsWithSameValue()), Sorter(1, NullChecking())],  Besides())
    
    def onePair(self):
        return ComposedSorter([Sorter(2, CardsWithSameValue()), Sorter(3, NullChecking())], Besides())
        
    def fullHouse(self):
        return ComposedSorter([Sorter(3, CardsWithSameValue()), Sorter(2, CardsWithSameValue())], Besides())
    
    def straightFlush(self):
        return ComposedSorter([self.straight(), self.flush()], AtTheSameTime())

class Sorter(object):
    def __init__(self, cardsCountInGroup, groupCriteria):
        self.numberOfCardRequired = cardsCountInGroup
        self.groupCriteria = groupCriteria
    
    def sort(self, hand):
        groupOfCardsOfSameKind = hand.groupCards(self.groupCriteria)
        for group in groupOfCardsOfSameKind:
            if len(group) == self.numberOfCardRequired:
                return Hand(group)
        return NullHand()

class ComposedSorter:
    def __init__(self, rulelist, ruleRelationShip):
        self.rule = rulelist
        self.ruleRelationship = ruleRelationShip
    
    def sort(self, hand):
        collectiveResult = Hand([])
        candidate = hand
        
        for eachRule in self.rule:
            matchedHand = eachRule.sort(candidate)
            if matchedHand.__cmp__(NullHand()) == 0:
                return NullHand()
            candidate = self.ruleRelationship.nextCandidate(candidate, matchedHand)
            collectiveResult = self.ruleRelationship.collectResult(collectiveResult, matchedHand)
        
        return collectiveResult

class Besides:
    def nextCandidate(self, candidate, matchedHand):
        return candidate.takeAway(matchedHand)
    
    def collectResult(self, collectiveResult, matchedHand):
        return matchedHand.appendTo(collectiveResult)
    
class AtTheSameTime:
    def nextCandidate(self, candidate, matchedHand):
        return candidate
    
    def collectResult(self, collectiveResult, matchedHand):
        return matchedHand
    
class NullChecking:
    def inGroup(self, card, group):
        return True

class CardsWithSameValue:
    def inGroup(self, card, group):
        return card.__cmp__(group[0]) == 0

class CardsInSameSuit:
    def inGroup(self, card, group):
        return card.sameSuitWith(group[0])

class CardsInSequence:
    def inGroup(self, card, group):
        if card.hasNext() is not True:
            return False
        return card.getNext().__cmp__(group[-1]) == 0