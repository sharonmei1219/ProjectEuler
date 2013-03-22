from Card import Card
from Hand import Hand

class HandsBuilder():
    def straightFlush(self, leastValue, suit):
        card = Card(leastValue, suit)
        cards = [card]
        for _ in range(0, 4):
            card = card.getNext()
            cards.append(card)
        return Hand(cards)
    
    def FourOfAKind(self, value):
        cards = [Card(value, 'S'), Card(value, "H"), Card(value, 'C'), Card(value, 'D'), Card('2', 'D')]
        return Hand(cards)
    
    def FullHouse(self, value1, value2):
        cards = [Card(value1, 'S'), Card(value1, "H"), Card(value1, 'C'), Card(value2, 'D'), Card(value2, 'D')]
        return Hand(cards)
    
    def Flush(self, value1, value2, value3, value4, value5, suit):
        cards = [Card(value1, suit), Card(value2, suit), Card(value3, suit), Card(value4, suit), Card(value5, suit)]
        return Hand(cards)
    
    def Straight(self, value):
        card = Card(value, 'S')
        cards = [card]
        suits = ['D', 'H', 'C', 'S']
        for index in range(4):
            card = card.getNext()
            card.suit = suits[index]
            cards.append(card)
        return Hand(cards)
    
    def ThreeOfAKind(self, value1, value2, value3):
        cards = [Card(value1, 'D'), Card(value1, 'S'), Card(value1, 'H'), Card(value2, 'C'), Card(value3, 'D')]
        return Hand(cards)
    
    def TwoPairs(self, value1, value2, value3):
        cards = [Card(value1, 'D'), Card(value1, 'S'), Card(value2, 'H'), Card(value2, 'C'), Card(value3, 'D')]
        return Hand(cards)
    
    def OnePair(self, value1, value2, value3, value4):
        cards = [Card(value1, 'D'), Card(value1, 'H'), Card(value2, 'C'), Card(value3, 'D'), Card(value4, 'S')]
        return Hand(cards)
    
    def HighCards(self, value1, value2, value3, value4, value5):
        cards = [Card(value1, 'D'), Card(value2, 'C'), Card(value3, 'D'), Card(value4, 'S'), Card(value5, 'H')]
        return Hand(cards)