class ComparableCard(object):
    def __cmp__(self, other):
        return self.order() - other.order()

class Card(ComparableCard):

    VALUES = ['2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'] 
    def __init__(self, value, suit):
        self.value = value
        self.suit = suit
    
    def equals(self, card):
        return self.__cmp__(card) == 0 and self.sameSuitWith(card)
    
    def sameSuitWith(self, card):
        return self.suit == card.suit

    def order(self):
        return self.VALUES.index(self.value)
    
    def getNext(self):
        return Card(self.VALUES[self.order() + 1], self.suit)
    
    def hasNext(self):
        return self.value != 'A'

class NullCard(ComparableCard):
    def order(self):
        return -1