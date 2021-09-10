import java.text.MessageFormat;
import java.util.*;

public class Project30 {

	private static class Song {
		private int downloads = 0;
		private final String songName;
		private String artistName;
		private final double runTime;
		private final String type;

		Song() {
			artistName = "unknown";
			songName = "new song";
			runTime = 0.0;
			type = "generic";
		}

		Song(String songNameI, String artistNameI, double runTimI) {
			artistName = artistNameI;
			songName = songNameI;
			runTime = runTimI;
			type = "mod";
		}

		public String show() {
			String summary = MessageFormat.format("''{0}'' by {1}; {2}", songName, artistName, runTime);
			return switch (type) {
				case "mod" -> summary;
				case "generic" -> MessageFormat.format("""
						Generic Title: {0}
						Generic Artist: {1}
						Generic Length: {2}
						Generic Downloads: {3}
						
						Generic Summary: {4}
						""", songName, artistName, runTime, downloads, summary);
				default -> "ERROR";
			};
		}

		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}

		public String shortArtistDisplay() {
			return "%s is sung by %s".formatted(songName, artistName);
		}

		public void download() { downloads++; }

		public int getDownloads() { return downloads; }

		public String getArtistName() {
			return artistName;
		}



	}


	public static void main(String[] args) {
		//Arrays.asList("a", "b", "c").forEach(new Song("Red House","Jimi Hendrix",3.73)::getDownloads);
		Song song1 = new Song("Red House", "Jimi Hendrix", 3.73);
		Song genSong = new Song();
		Song cSong = new Song("Let's Go Crazy", "Prince", 3.77);

		String original = cSong.shortArtistDisplay();
		cSong.setArtistName("the artist formerly known as Prince");
		String after = cSong.shortArtistDisplay();
		String generic = genSong.show();
		song1.download();
		song1.download();
		song1.download();
		song1.download();

		System.out.println(MessageFormat.format(
				"My Song''s Artist is {0}\nIt has been downloaded 0 times.\n\nNow it has been downloaded {1} times\n{2}\n\n\n{3}\n\n{4}\n\n\n{5}\n",
				song1.getArtistName(),
				song1.getDownloads(),
				song1.show(),
				original,
				after,
				generic
		));
	}
}

