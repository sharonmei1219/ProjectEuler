from Card import Card
from Card import NullCard

class Hand():
    def __init__(self, cards):
        self.cards = cards
    
    def takeAway(self, hand):
        restCards = [card for card in self.cards if card not in hand.cards]
        return Hand(restCards)
    
    def appendTo(self, hand):
        cardsInHand = reduce(lambda cardsInHand, card: cardsInHand + [card], self.cards, hand.cards[:])
        return Hand(cardsInHand)
    
    def groupCards(self, criteria):
        sortedCards = sorted(self.cards, key = Card.order, reverse = True)
        addCardsInGroups = lambda groups, card: self.__addCardInProperGroup(groups, card, criteria)
        return reduce(addCardsInGroups, sortedCards, [])
    
    def __addCardInProperGroup(self, groups, card, criteria):
        result = groups[:][:]
        self.__seekProperGroup(card, result, criteria).append(card)
        return result
    
    def __seekProperGroup(self, card, groups, criteria):
        for eachGroup in groups:
            if criteria.inGroup(card, eachGroup) == True:
                return eachGroup
        newGroup = []
        groups.append(newGroup)
        return newGroup
    
    def __cmp__(self, objHand):
        return cmp(self.cards, objHand.cards)

def NullHand():
    return Hand([NullCard()] * 5)