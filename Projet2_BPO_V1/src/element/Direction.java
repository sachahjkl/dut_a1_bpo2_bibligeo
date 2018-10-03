package element;

public enum Direction {
	Nord{
		@Override
		public Direction previous() {
	        return Nord_Ouest;
	    };
	},
	Nord_Est,
	Est,
	Sud_Est,
	Sud,
	Sud_Ouest,
	Ouest,
	Nord_Ouest{
		@Override
		public Direction next() {
	        return Nord;
	    };
	};
	
	public Direction next() {
        return values()[ordinal() + 1];
    }
	
	public Direction previous() {
        return values()[ordinal() - 1];
    }
}
