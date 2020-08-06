sealed trait Music

sealed trait Melody extends Music
final case class MelodyPart(firstAction: MusicAction, tail: Melody) extends Melody
final case object MelodyEnd extends Melody

sealed trait MusicAction extends Music {
  def length: Duration

  def bar: Int
}

sealed trait Tone extends Music {
  def letter: Char

  def octave4Frequency: Double

  def octave4Wavelength: Double
}

sealed trait Duration extends Music {
  def baseDuration: BaseDuration

  def isDotted: Boolean

  sealed trait BaseDuration {
    def value: Double
  }

  case object Whole extends BaseDuration {
    val value = 1
  }

  case object Half extends BaseDuration {
    val value = 1 / 2
  }

  case object Quarter extends BaseDuration {
    val value = 1 / 4
  }

}

final case class Octave(value: Int) extends Music

final case class Key(value: String) extends Music

sealed trait Accidental extends Music





final case class Note(
                       tone: Tone,
                       octave: Octave,
                       length: Duration,
                       key: Key,
                       bar: Int,
                       accidental: Accidental
                     ) extends MusicAction

final case class Rest(
                       length: Duration,
                       bar: Int
                     ) extends MusicAction

object C extends Tone {
  val letter = 'C'
  val octave4Frequency = 261.63
  val octave4Wavelength = 131.87
}

object D extends Tone {
  val letter = 'D'
  val octave4Frequency = 293.66
  val octave4Wavelength = 117.48
}

case object Flat extends Accidental

case object Sharp extends Accidental

case object Natural extends Accidental
