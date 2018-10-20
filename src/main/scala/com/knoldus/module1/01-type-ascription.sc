trait Thing
def getThing = new Thing { }

// without Type Ascription, the type is infered to be `Thing`
val infered = getThing

// with Type Ascription
val thing: Thing = getThing