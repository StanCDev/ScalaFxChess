package ScalaFx

import Components.Piece
import Components.Piece.King
import Components.Piece.Queen
import Components.Piece.Rook
import Components.Piece.Knight
import Components.Piece.Bishop
import Components.Piece.Pawn
import Components.Piece.Empty

object PieceSVG {
    def toSVG(piece : Piece): String = 
        val out = piece match
            case Queen(isWhite) => 
                if isWhite then 
                    """M 4 -16 c 1.056 1.088 1.152 1.92 0.416 3.904 c -0.672 1.824 -0.672 6.336 0.032 9.536 c 0.256 1.312 0.544 2.432 0.608 2.496 c 0.16 0.16 2.08 -4.832 2.592 -6.848 c 0.352 -1.312 0.448 -2.528 0.288 -4.128 c -0.192 -2.08 -0.128 -2.304 0.64 -3.232 c 2.016 -2.4 5.632 -1.152 5.632 1.984 c 0 1.12 -0.192 1.632 -0.992 2.528 c -0.512 0.608 -1.088 1.6 -1.28 2.176 c -0.32 1.184 -0.384 4.608 -0.096 6.432 l 0.224 1.216 l 0.896 -1.056 c 2.112 -2.4 2.656 -3.744 2.592 -6.112 c -0.064 -2.56 0.448 -3.808 1.824 -4.384 c 2.08 -0.832 4.512 0.832 4.512 3.104 c 0 0.896 -0.256 1.408 -1.248 2.4 c -1.024 0.992 -1.344 1.632 -1.632 3.072 c -0.192 0.992 -0.736 3.52 -1.184 5.632 c -0.768 3.424 -0.992 3.904 -2.176 5.28 c -2.912 3.264 -3.104 3.872 -2.112 6.176 c 0.896 2.08 1.12 3.808 0.576 4.544 c -0.672 0.928 -3.936 1.472 -10.304 1.696 c -6.08 0.192 -11.552 -0.224 -13.504 -1.024 c -1.088 -0.448 -1.216 -0.8 -1.056 -2.88 c 0.032 -0.512 0.352 -1.472 0.672 -2.144 c 1.12 -2.208 0.896 -2.848 -2.144 -6.592 c -1.376 -1.664 -2.08 -3.968 -3.168 -10.112 c -0.352 -2.016 -0.544 -2.432 -1.76 -3.648 c -1.248 -1.248 -1.344 -1.44 -1.184 -2.656 c 0.32 -2.464 2.784 -3.872 4.64 -2.656 c 1.44 0.928 1.664 1.44 1.632 3.84 c -0.064 2.528 0.48 3.872 2.368 6.144 c 1.056 1.248 1.12 1.28 1.312 0.608 c 0.32 -1.216 0.224 -5.824 -0.16 -6.976 c -0.224 -0.608 -0.8 -1.664 -1.28 -2.336 c -1.216 -1.664 -1.216 -3.072 -0.032 -4.384 c 0.768 -0.832 1.152 -1.024 2.304 -1.024 c 1.184 -0 1.536 0.16 2.336 1.056 c 0.896 1.024 0.928 1.152 0.736 3.2 c -0.224 2.496 0.48 5.728 1.984 9.152 c 1.088 2.432 1.056 2.432 1.824 -1.92 c 0.64 -3.712 0.608 -4.704 -0.192 -7.712 c -0.544 -2.08 -0.576 -2.656 -0.256 -3.424 c 0.864 -2.08 3.488 -2.56 5.12 -0.928 z m -3.488 1.824 c -0.128 1.216 0.576 1.888 1.696 1.6 c 0.64 -0.16 0.8 -0.384 0.8 -1.28 c -0 -1.312 -0.224 -1.536 -1.44 -1.408 c -0.8 0.096 -0.96 0.256 -1.056 1.088 z m 9.728 0.864 c -0.384 0.288 -0.544 0.736 -0.448 1.344 c 0.064 0.8 0.256 0.992 1.056 1.056 c 0.608 0.096 1.056 -0.064 1.344 -0.448 c 0.544 -0.768 0.544 -0.96 -0.224 -1.728 c -0.768 -0.768 -0.96 -0.768 -1.728 -0.224 z m -18.56 0 c -0.384 0.288 -0.544 0.736 -0.448 1.344 c 0.096 0.864 0.224 0.96 1.184 0.96 c 1.408 -0 1.952 -1.12 0.992 -2.08 c -0.736 -0.736 -0.96 -0.768 -1.728 -0.224 z m 26.112 3.808 c -0.64 0.64 -0.48 2.112 0.256 2.336 c 1.184 0.384 1.92 -0.096 1.92 -1.28 c -0 -0.576 -0.192 -1.152 -0.416 -1.216 c -0.704 -0.288 -1.376 -0.224 -1.76 0.16 z m -33.92 0 c -0.864 0.864 -0.224 2.496 0.928 2.496 c 0.672 -0 1.568 -0.832 1.568 -1.44 c -0 -1.12 -1.696 -1.856 -2.496 -1.056 z m 25.216 4.64 c 0 0.768 -1.92 4.48 -3.104 6.016 l -1.152 1.536 l -0.576 -0.768 c -0.672 -0.864 -2.208 -5.376 -2.208 -6.496 c -0 -1.728 -0.48 -0.96 -1.152 1.824 c -0.704 2.944 -1.856 5.504 -2.368 5.184 c -0.608 -0.384 -2.656 -3.776 -3.68 -6.08 l -1.12 -2.56 l 0 2.08 c 0 2.176 -0.736 7.232 -1.088 7.584 c -0.096 0.096 -1.504 -1.12 -3.104 -2.752 c -1.6 -1.6 -2.816 -2.656 -2.72 -2.368 c 0.096 0.32 0.416 1.664 0.704 2.976 c 0.48 2.272 1.216 4.16 1.6 4.16 c 0.064 -0 0.736 -0.32 1.472 -0.672 c 4.8 -2.464 16.512 -2.496 21.92 -0.096 c 1.312 0.576 1.888 0.672 2.208 0.416 c 0.224 -0.16 0.704 -1.664 1.088 -3.264 c 0.352 -1.632 0.736 -3.168 0.832 -3.488 c 0.096 -0.288 -1.152 0.8 -2.752 2.4 c -1.6 1.568 -2.976 2.784 -3.072 2.688 c -0.352 -0.352 -1.088 -5.408 -1.088 -7.584 c -0 -1.472 -0.096 -1.952 -0.32 -1.6 c -0.16 0.256 -0.32 0.672 -0.32 0.864 z m -10.24 10.016 c -2.016 0.192 -4.256 0.48 -4.96 0.672 c -1.216 0.32 -2.4 1.088 -2.4 1.568 c 0 0.096 4.608 0.192 10.24 0.224 c 5.632 -0 10.24 -0.096 10.24 -0.256 c -0 -0.416 -1.376 -1.248 -2.72 -1.632 c -0.704 -0.192 -2.432 -0.448 -3.84 -0.576 c -1.408 -0.128 -2.624 -0.256 -2.72 -0.256 c -0.096 -0.032 -1.824 0.096 -3.84 0.256 z m -4.224 4.704 c -2.144 0.192 -2.176 0.192 -1.92 1.024 c 0.128 0.448 0.224 1.28 0.192 1.792 l 0 0.992 l 1.6 -0.224 c 0.896 -0.128 4.16 -0.256 7.232 -0.256 c 3.072 -0 6.336 0.128 7.232 0.256 l 1.6 0.224 l -0 -0.992 c -0.032 -0.512 0.096 -1.344 0.224 -1.824 c 0.224 -0.832 0.192 -0.864 -1.28 -0.992 c -2.752 -0.192 -12.704 -0.224 -14.88 0 z m -1.12 5.856 c -1.28 0.448 -1.568 1.152 -0.672 1.632 c 1.664 0.896 13.728 1.056 16.96 0.256 c 1.248 -0.32 1.664 -1.248 0.832 -1.76 c -1.216 -0.768 -15.072 -0.864 -17.12 -0.128 z"""
                else 
                    """M -0 -16.25 c 0.875 0.675 1.025 1.7 0.5 3.375 c -0.575 1.825 -0.55 4.325 0.025 7.3 l 0.425 2.25 l 0.575 -1.25 c 1.2 -2.65 1.825 -4.95 1.775 -6.5 c -0.025 -0.825 -0.05 -1.8 -0.05 -2.175 c -0.05 -1.625 1.8 -2.775 3.4 -2.1 c 1.05 0.425 1.425 0.95 1.575 2.1 c 0.1 0.825 0.025 1.1 -0.65 1.85 c -1.125 1.275 -1.275 1.925 -1.275 5.15 l 0.025 2.925 l 0.975 -1.075 c 1.55 -1.725 2.1 -3.075 1.9 -4.75 c -0.125 -1.175 -0.075 -1.575 0.35 -2.25 c 0.85 -1.375 2.175 -1.65 3.5 -0.75 c 1.55 1.05 1.475 3.125 -0.125 4.325 c -0.7 0.55 -0.825 0.825 -0.975 2.125 c -0.1 0.8 -0.5 2.725 -0.875 4.225 c -0.625 2.425 -0.875 2.95 -1.975 4.325 c -0.675 0.875 -1.425 1.95 -1.65 2.4 c -0.4 0.775 -0.4 0.875 0.225 2.575 c 1.075 3 0.875 3.35 -2.25 4.15 c -2.4 0.6 -11.35 0.6 -14.1 0 c -2.95 -0.65 -3.325 -1.375 -2.125 -4.225 c 0.375 -0.9 0.575 -1.75 0.5 -2.1 c -0.075 -0.3 -0.85 -1.425 -1.675 -2.5 c -1.475 -1.85 -1.55 -2.025 -2.25 -4.9 c -0.375 -1.65 -0.775 -3.575 -0.85 -4.3 c -0.15 -1.075 -0.3 -1.35 -0.975 -1.775 c -1.725 -1.125 -1.625 -3.675 0.175 -4.525 c 1.1 -0.525 2 -0.325 2.975 0.675 c 0.725 0.725 0.75 0.8 0.575 2.325 c -0.15 1.4 -0.075 1.75 0.45 2.8 c 0.35 0.675 1.025 1.675 1.525 2.225 l 0.875 1 l 0.075 -1.5 c 0.175 -3.875 -0.15 -5.45 -1.25 -6.475 c -1.875 -1.675 0.175 -4.95 2.575 -4.15 c 1.5 0.5 1.75 1.025 1.675 3.525 c -0.05 1.925 0.025 2.525 0.675 4.475 c 0.425 1.25 0.975 2.675 1.225 3.175 l 0.475 0.9 l 0.4 -2.25 c 0.525 -2.825 0.55 -5.675 0.05 -7.075 c -0.55 -1.55 -0.475 -2.575 0.25 -3.35 c 0.725 -0.8 2.4 -0.9 3.325 -0.2 z m -2.4 1.1 c -0.425 0.425 -0.375 1.325 0.075 1.7 c 0.95 0.775 2.4 -0.675 1.625 -1.625 c -0.375 -0.45 -1.275 -0.5 -1.7 -0.075 z m 7.15 1.55 c -0.575 0.875 0 1.7 1.075 1.6 c 0.725 -0.075 0.85 -0.175 0.925 -0.825 c 0.075 -0.475 -0.05 -0.825 -0.35 -1.05 c -0.475 -0.35 -1.35 -0.2 -1.65 0.275 z m -14.3 -0.275 c -0.3 0.225 -0.425 0.575 -0.35 1.05 c 0.05 0.6 0.2 0.775 0.775 0.825 c 1.35 0.15 1.925 -1.075 0.875 -1.8 c -0.675 -0.475 -0.75 -0.475 -1.3 -0.075 z m 20.4 2.975 c -0.425 0.425 -0.375 1.325 0.075 1.7 c 0.5 0.425 1.55 0.125 1.75 -0.5 c 0.35 -1.1 -1.025 -2 -1.825 -1.2 z m -26.4 0.1 c -0.475 0.45 -0.5 0.7 -0.15 1.375 c 0.5 0.925 2 0.45 2 -0.65 c -0 -1.05 -1.1 -1.475 -1.85 -0.725 z m 6.975 12.125 c -0.7 0.25 -1.025 0.525 -1.075 0.875 l -0.075 0.55 l 8.125 -0.025 c 7.75 -0.025 8.15 -0.05 8.15 -0.475 c -0 -1.05 -2.725 -1.45 -9.125 -1.35 c -3.375 0.075 -5.325 0.2 -6 0.425 z m 1.025 5.45 c -0.525 0.125 -1.15 0.425 -1.375 0.625 c -0.325 0.35 -0.325 0.45 -0.025 0.75 c 0.325 0.3 1 0.325 4 0.175 c 2 -0.125 5.125 -0.125 6.975 -0 c 3.275 0.225 4.025 0.1 4.025 -0.55 c -0 -0.4 -1.425 -0.95 -3.025 -1.2 c -1.9 -0.3 -9.175 -0.15 -10.575 0.2 z"""
            case King(isWhite) =>
                if isWhite then 
                    """M 0.8 -24 c 0.384 0.896 0.672 1.12 1.504 1.216 c 0.928 0.096 1.056 0.224 1.152 1.12 c 0.096 0.928 -0.032 1.088 -1.184 1.696 c -1.504 0.736 -1.792 1.952 -0.672 2.56 c 1.28 0.672 2.56 2.88 2.56 4.384 c 0 1.28 0.352 1.76 0.768 1.088 c 0.48 -0.736 3.168 -1.632 4.96 -1.632 c 3.904 -0 6.624 2.144 7.2 5.632 c 0.384 2.144 -0.064 3.456 -2.368 7.008 c -2.24 3.456 -2.688 4.64 -3.168 8.672 c -0.16 1.248 -0.448 2.56 -0.64 2.912 c -0.48 0.96 -2.72 1.888 -5.536 2.336 c -3.36 0.544 -11.616 0.256 -13.984 -0.48 c -2.624 -0.8 -3.392 -1.76 -3.648 -4.48 c -0.352 -3.488 -1.024 -5.472 -2.752 -8.096 c -2.144 -3.296 -2.912 -5.056 -2.912 -6.848 c -0 -1.92 0.416 -3.04 1.696 -4.352 c 2.464 -2.592 5.984 -3.168 9.184 -1.472 c 0.96 0.512 1.856 0.96 1.984 1.024 c 0.16 0.064 0.256 -0.704 0.256 -1.696 c -0 -1.696 0.064 -1.856 1.44 -3.168 c 1.76 -1.728 1.824 -2.464 0.32 -3.392 c -0.928 -0.576 -1.12 -0.896 -1.12 -1.792 c -0 -1.024 0.064 -1.088 1.088 -1.088 c 0.96 -0 1.152 -0.128 1.472 -1.12 c 0.288 -0.864 0.544 -1.12 1.152 -1.12 c 0.608 -0 0.928 0.256 1.248 1.088 z m -2.208 8.544 c -0.928 0.416 -1.472 1.76 -1.472 3.52 c 0 1.216 1.76 5.088 2.4 5.312 c 0.192 0.064 0.8 -0.736 1.376 -1.792 c 1.568 -2.88 1.408 -6.368 -0.352 -7.072 c -0.96 -0.384 -1.024 -0.384 -1.952 0.032 z m 8.64 4.608 c -3.168 1.504 -6.144 5.632 -6.336 8.8 l -0.096 1.44 l 1.76 0.352 c 0.96 0.192 3.296 0.448 5.184 0.576 l 3.456 0.224 l 1.472 -2.016 c 2.496 -3.392 2.944 -5.248 1.728 -7.584 c -0.544 -1.088 -1.216 -1.6 -3.2 -2.4 c -0.768 -0.288 -2.688 0 -3.968 0.608 z m -20.224 -0.192 c -1.568 0.704 -2.592 2.048 -2.88 3.776 c -0.256 1.568 0.32 3.008 2.304 5.696 l 1.504 2.048 l 1.952 -0.128 c 1.088 -0.096 3.04 -0.224 4.384 -0.32 c 1.344 -0.064 2.848 -0.288 3.328 -0.48 c 0.832 -0.32 0.864 -0.448 0.704 -1.792 c -0.224 -2.08 -1.92 -5.344 -3.52 -6.72 c -1.664 -1.44 -4.224 -2.688 -5.504 -2.688 c -0.544 0 -1.536 0.288 -2.272 0.608 z m 6.976 13.312 c -2.528 0.224 -4.672 0.512 -4.768 0.576 c -0.16 0.16 0.416 4.352 0.608 4.544 c 0.064 0.064 1.088 -0.128 2.336 -0.416 c 3.936 -0.896 12.896 -0.672 16.64 0.416 c 0.576 0.192 0.672 -0.032 1.024 -2.144 c 0.192 -1.28 0.32 -2.368 0.288 -2.432 c -0.064 -0.032 -1.824 -0.224 -3.904 -0.416 c -2.08 -0.192 -4.384 -0.48 -5.088 -0.608 c -0.704 -0.16 -1.568 -0.192 -1.92 -0.128 c -0.352 0.096 -2.72 0.352 -5.216 0.608 z m -1.12 6.912 c -1.152 0.288 -1.568 0.992 -0.864 1.408 c 0.736 0.448 8.48 0.768 11.488 0.48 c 4.256 -0.416 5.056 -0.8 3.488 -1.632 c -1.472 -0.8 -11.232 -0.96 -14.112 -0.256 z"""
                else
                    """M 0.9 -19.08 C 1.2 -18.12 1.35 -18 2.28 -18 C 3.24 -18 3.3 -17.94 3.3 -16.98 C 3.3 -16.08 3.15 -15.84 2.1 -15.27 C 1.44 -14.88 0.9 -14.37 0.9 -14.13 C 0.9 -13.89 1.53 -13.02 2.31 -12.24 C 3.57 -10.98 3.72 -10.65 3.84 -9.15 C 3.9 -8.25 4.02 -7.5 4.11 -7.5 C 4.17 -7.5 4.62 -7.77 5.07 -8.13 C 7.02 -9.57 10.56 -9.78 12.9 -8.55 C 14.1 -7.92 15.51 -6.18 15.87 -4.89 C 16.56 -2.43 16.14 -0.99 13.59 2.91 C 11.7 5.76 11.19 7.14 10.92 10.29 C 10.62 13.59 9.99 14.34 6.78 15.18 C 3.09 16.17 -5.52 15.96 -8.73 14.85 C -10.89 14.07 -11.31 13.47 -11.55 10.83 C -11.88 7.47 -12.57 5.55 -14.64 2.43 C -16.62 -0.54 -16.95 -1.59 -16.74 -3.93 C -16.29 -8.46 -11.07 -10.77 -6.6 -8.46 L -4.86 -7.56 L -4.65 -9.21 C -4.47 -10.65 -4.29 -11.01 -3.12 -12.12 C -1.5 -13.68 -1.44 -14.43 -2.85 -15.3 C -3.72 -15.84 -3.9 -16.14 -3.9 -16.98 C -3.9 -17.94 -3.84 -18 -2.88 -18 C -2.01 -18 -1.86 -18.12 -1.62 -18.99 C -1.38 -19.77 -1.17 -19.98 -0.39 -20.04 C 0.45 -20.13 0.57 -20.01 0.9 -19.08 Z M 6.75 -6.9 C 3.81 -5.49 1.74 -2.7 1.35 0.3 C 1.02 2.7 0.93 2.94 0.15 3.12 C -1.08 3.42 -1.8 2.85 -1.8 1.53 C -1.8 -2.76 -6.15 -7.5 -10.05 -7.5 C -12.93 -7.5 -14.7 -5.91 -14.7 -3.33 C -14.7 -1.14 -12.27 2.94 -10.05 4.47 C -9.18 5.04 -8.64 5.16 -6.87 5.16 C -5.7 5.13 -3.75 4.98 -2.52 4.8 C -0.96 4.56 0.33 4.56 1.89 4.77 C 4.14 5.1 6.03 5.22 7.8 5.13 C 8.67 5.1 9.15 4.77 10.65 3.21 C 13.77 -0.06 14.85 -3.39 13.53 -5.58 C 12.39 -7.44 9.18 -8.07 6.75 -6.9 Z M -7.17 10.02 C -7.74 10.2 -8.25 10.5 -8.31 10.71 C -8.58 11.49 -7.35 11.64 -3.81 11.34 C -1.41 11.13 0.81 11.13 3.21 11.34 C 6.63 11.64 7.8 11.49 7.8 10.77 C 7.8 10.23 6.18 9.84 3.15 9.63 C -0.45 9.36 -5.76 9.57 -7.17 10.02 Z M 10.71 -5.97 C 11.91 -5.61 12.9 -4.38 12.9 -3.21 C 12.9 -1.83 11.76 0.27 10.05 1.98 C 8.7 3.33 8.37 3.51 6.9 3.69 C 5.07 3.9 3.06 3.54 2.64 2.94 C 2.01 2.01 3 -1.62 4.35 -3.42 C 6 -5.52 8.58 -6.57 10.71 -5.97 Z M -8.79 -6 C -6.06 -5.37 -3.84 -2.61 -3.27 0.84 C -2.88 3.27 -3.36 3.66 -6.45 3.66 C -8.67 3.66 -8.76 3.63 -10.14 2.49 C -12 0.93 -13.5 -1.56 -13.5 -3.09 C -13.5 -3.96 -13.29 -4.47 -12.63 -5.13 C -12.15 -5.61 -11.49 -6 -11.16 -6 C -10.83 -6 -10.38 -6.06 -10.14 -6.12 C -9.93 -6.18 -9.3 -6.12 -8.79 -6 Z"""
            case Rook(isWhite) => 
                if isWhite then """M 12.8 -20 c 0.8 0.832 0.864 1.12 0.864 3.488 l 0 2.592 l -2.528 2.208 l -2.56 2.176 l 0 5.92 l -0.032 5.92 l 2.88 2.88 l 2.88 2.88 l 0 2.24 c 0 1.344 -0.16 2.432 -0.384 2.656 c -0.288 0.288 -3.84 0.384 -14.016 0.384 c -15.776 0 -14.72 0.224 -14.72 -3.072 l -0 -1.888 l 3.04 -3.104 l 3.04 -3.104 l -0 -5.728 l -0 -5.76 l -2.56 -2.176 l -2.56 -2.208 l -0 -2.752 c -0 -2.56 0.064 -2.784 0.896 -3.584 c 0.8 -0.768 1.12 -0.864 3.296 -0.864 c 2.688 -0 3.904 0.64 3.584 1.92 c -0.16 0.544 -0.032 0.64 0.832 0.64 c 0.832 -0 0.992 -0.128 0.992 -0.736 c -0 -1.44 0.896 -1.824 4.224 -1.824 c 3.296 -0 4.096 0.384 4.096 1.856 c 0 0.544 0.192 0.704 0.8 0.704 c 0.64 -0 0.8 -0.16 0.8 -0.736 c -0 -1.376 0.928 -1.824 3.712 -1.824 c 2.4 -0 2.624 0.064 3.424 0.896 z m -5.216 2.4 c 0 1.152 -0.608 1.504 -2.592 1.504 c -2.432 0 -2.848 -0.192 -2.848 -1.312 l -0 -0.928 l -2.24 0 c -2.112 0 -2.24 0.032 -2.24 0.736 c 0 1.184 -0.608 1.504 -2.944 1.504 c -1.856 0 -2.208 -0.096 -2.496 -0.672 c -0.224 -0.352 -0.288 -0.864 -0.192 -1.12 c 0.128 -0.352 -0.224 -0.448 -1.696 -0.448 c -2.144 0 -2.272 0.16 -2.272 2.496 c 0 1.44 0.064 1.568 1.92 3.008 l 1.888 1.536 l 7.936 -0 l 7.936 -0 l 1.92 -1.536 c 1.888 -1.536 1.92 -1.6 1.92 -3.136 c -0.032 -0.864 -0.128 -1.76 -0.288 -1.984 c -0.128 -0.224 -0.928 -0.384 -1.984 -0.384 c -1.6 0 -1.728 0.064 -1.728 0.736 z m -14.4 13.664 l 0 5.12 l 6.592 -0.064 l 6.56 -0.096 l 0.064 -5.056 l 0.064 -5.024 l -6.656 0 l -6.624 0 l 0 5.12 z m -2.144 8.704 c -0.928 0.928 -1.696 1.76 -1.696 1.856 c 0 0.096 4.704 0.128 10.464 0.064 l 10.464 -0.096 l -1.728 -1.728 l -1.728 -1.76 l -7.04 0 l -7.04 0 l -1.696 1.664 z m -3.936 5.216 l 0 1.12 l 12.64 -0 l 12.64 -0 l -0 -1.12 l -0 -1.12 l -12.64 0 l -12.64 0 l 0 1.12 z"""
                else """M 11.52 -14.4 c 0.6912 0.72 0.7776 1.008 0.7776 2.9664 l 0 2.16 l -2.16 2.1312 l -2.16 2.1312 l 0 5.0688 l 0 5.04 l 2.736 2.736 l 2.736 2.736 l 0 1.9008 c 0 3.0528 0.9504 2.8512 -13.1616 2.8512 c -14.0256 0 -13.0464 0.2304 -13.0464 -2.9088 l -0 -1.8432 l 2.592 -2.592 l 2.592 -2.592 l -0 -5.184 l -0 -5.2128 l -2.016 -1.9872 l -2.016 -1.9872 l -0 -2.4768 c -0 -2.2176 0.0576 -2.5632 0.6624 -3.1104 c 0.5472 -0.5184 1.008 -0.6336 2.6784 -0.6336 c 2.16 -0 2.7072 0.2592 2.7072 1.3536 c 0 0.576 0.144 0.6624 1.008 0.6624 c 0.864 -0 1.008 -0.0864 1.008 -0.6624 c -0 -1.1808 0.4896 -1.3536 3.744 -1.3536 c 3.2544 -0 3.744 0.1728 3.744 1.3536 c 0 0.576 0.144 0.6624 1.008 0.6624 c 0.7776 -0 1.008 -0.1152 1.008 -0.5184 c -0 -1.0368 0.9216 -1.4976 2.9088 -1.4976 c 1.6704 -0 1.9584 0.0864 2.6496 0.8064 z m -17.0784 9.9936 l 0 1.008 l 5.8176 -0.0576 l 5.8464 -0.0864 l 0.0864 -0.9504 l 0.0864 -0.9216 l -5.904 0 l -5.9328 0 l 0 1.008 z m 0 9.36 l 0 0.864 l 5.904 -0 l 5.904 -0 l -0 -0.864 l -0 -0.864 l -5.904 0 l -5.904 0 l 0 0.864 z"""
            case Knight(isWhite) => 
                if isWhite then """M 10 -20 c 0.448 0.512 0.864 1.088 0.928 1.28 c 0.064 0.224 0.736 0.064 1.792 -0.48 c 0.896 -0.448 2.4 -0.928 3.296 -1.024 l 1.632 -0.192 l -0.224 1.952 c -0.256 2.24 0.192 4.16 1.888 7.808 c 3.008 6.56 4.32 9.536 4.8 11.04 l 0.576 1.696 l -0.928 1.28 c -1.024 1.44 -2.688 2.368 -3.84 2.144 c -0.544 -0.096 -1.024 0.096 -1.568 0.64 c -1.248 1.248 -2.272 0.896 -3.712 -1.184 c -0.672 -0.96 -1.76 -2.304 -2.432 -2.976 c -1.216 -1.28 -3.808 -2.976 -4.096 -2.688 c -0.384 0.384 0.448 2.112 2.592 5.344 c 2.336 3.456 3.68 6.368 3.68 7.84 l 0 0.8 l -12.128 0 l -12.128 0 l -0.224 -2.336 c -0.288 -3.008 0.288 -9.248 1.12 -12.544 c 1.216 -4.704 3.84 -9.248 6.944 -12 c 2.048 -1.792 3.648 -2.592 5.728 -2.784 c 1.6 -0.16 1.728 -0.256 2.08 -1.28 c 0.448 -1.408 2.112 -3.296 2.848 -3.296 c 0.32 -0 0.928 0.416 1.376 0.96 z m 4.32 2.112 l -1.024 0.512 l 0.8 0.448 c 1.184 0.672 1.568 0.544 1.568 -0.512 c -0 -1.12 -0.032 -1.12 -1.344 -0.448 z m -6.336 1.024 c -0.96 3.072 -0.8 2.944 -3.296 2.944 c -1.696 0 -2.496 0.16 -3.296 0.672 c -1.76 1.088 -4.672 4.544 -6.112 7.2 c -2.08 3.904 -2.688 6.496 -2.88 12.192 l -0.192 4.864 l 9.664 0.096 c 7.68 0.064 9.632 -0 9.632 -0.32 c -0 -0.608 -1.184 -2.816 -2.848 -5.344 c -2.24 -3.36 -2.912 -5.088 -2.912 -7.52 c -0 -0.8 -0.352 -2.624 -0.768 -4.032 c -0.832 -2.784 -0.8 -3.488 0.16 -3.008 c 0.8 0.448 2.08 2.72 2.528 4.48 c 0.32 1.28 0.544 1.568 1.824 2.24 c 1.952 1.024 4.416 3.328 6.016 5.568 c 1.376 1.888 1.984 2.112 1.824 0.672 c -0.096 -0.832 -0.032 -0.864 0.8 -0.672 c 2.432 0.608 2.816 0.576 3.712 -0.32 c 0.704 -0.672 0.864 -1.088 0.704 -1.696 c -0.096 -0.48 -1.536 -3.648 -3.168 -7.072 c -1.632 -3.424 -3.168 -6.688 -3.392 -7.264 c -0.32 -0.832 -0.736 -1.152 -2.144 -1.696 c -2.816 -1.056 -4.256 -1.888 -4.64 -2.72 c -0.448 -0.992 -0.736 -0.8 -1.216 0.736 z M 15.568 -10.72 c 1.056 0.64 1.6 1.824 1.248 2.72 c -0.256 0.704 -1.056 0.608 -2.656 -0.32 c -1.312 -0.8 -2.016 -1.952 -1.536 -2.688 c 0.32 -0.544 1.824 -0.416 2.944 0.288 z M 21.264 0.032 c 0.704 0.736 0.48 1.856 -0.384 1.984 c -0.96 0.128 -1.696 -1.248 -1.056 -2.016 c 0.512 -0.608 0.8 -0.608 1.44 0.032 z"""
                else """M 4 -20 l 1.28 1.56 l 2.16 -1 c 1.2 -0.56 3.04 -1.04 4.04 -1.04 l 1.84 -0.08 l -0.08 2.8 c -0.08 3.36 0.4 4.92 4.36 13.36 c 1.6 3.4 3.32 7.36 3.8 8.88 c 0.88 2.6 0.92 2.72 0.2 3.84 c -1 1.68 -2.48 2.72 -4.64 3.32 c -1.28 0.36 -2.04 0.4 -2.52 0.12 c -0.48 -0.32 -0.72 -0.2 -1.04 0.44 c -0.24 0.48 -0.8 0.88 -1.28 0.96 c -0.68 0.12 -1.28 -0.48 -2.88 -2.84 c -1.08 -1.64 -2.56 -3.44 -3.28 -4.04 c -1.44 -1.24 -4.36 -2.8 -4.64 -2.52 c -0.4 0.4 1.52 4 3.8 7.2 c 1.32 1.8 2.64 3.8 3 4.48 c 0.48 0.96 1.48 4.8 1.48 5.6 c 0 0.12 -6.92 0.2 -15.36 0.2 l -15.32 0 l -0.28 -1.84 c -0.88 -6.68 0.8 -17.44 3.64 -23.16 c 3.52 -7 8.64 -11.52 13.88 -12.16 c 1.88 -0.24 2 -0.32 2.52 -1.92 c 0.56 -1.68 2.48 -3.72 3.52 -3.72 c 0.32 -0 1.12 0.72 1.8 1.56 z m -8.32 7.84 c -4.16 1.24 -9.76 7.88 -11.76 14 c -1.2 3.64 -1.92 8.2 -1.92 12.16 c 0 2.88 0.6 4.24 1.68 3.84 c 0.84 -0.32 1.12 -1.44 1.12 -4.84 c -0 -3.76 0.96 -9.24 2.16 -12.16 c 2.16 -5.28 6.56 -10.04 10.64 -11.48 c 1.92 -0.68 2.52 -1.44 1.48 -1.84 c -0.8 -0.36 -1.24 -0.32 -3.4 0.32 z m 11.64 3.28 c -0.12 0.28 0.52 1.24 1.36 2.12 c 1.16 1.28 1.84 1.68 2.92 1.72 c 2.04 0.12 2.12 -1.28 0.24 -3.16 c -1.2 -1.2 -1.64 -1.4 -2.88 -1.28 c -0.84 0.08 -1.56 0.32 -1.64 0.6 z m 10.28 14.44 c 0 1 0.84 2 1.8 2.16 c 0.64 0.08 0.76 -0.08 0.68 -0.88 c -0.16 -1.64 -2.48 -2.84 -2.48 -1.28 z"""
            case Bishop(isWhite) => 
                if !isWhite then 
                    """M 2.31 -15.33 C 3.75 -14.43 4.11 -12.36 3.15 -10.53 L 2.7 -9.66 L 4.08 -9 C 4.83 -8.64 6.42 -7.38 7.65 -6.18 C 9.51 -4.35 9.9 -3.81 10.35 -2.31 C 11.1 0.27 10.53 2.52 8.31 5.64 C 7.41 6.9 7.38 6.96 7.77 8.34 C 8.7 11.61 8.43 12.45 6.24 12.78 C 5.61 12.9 5.1 13.08 5.1 13.17 C 5.1 13.65 8.04 14.1 10.98 14.1 C 14.64 14.1 15.39 14.37 16.74 16.23 L 17.67 17.49 L 16.5 19.23 C 15.84 20.19 15 21.18 14.67 21.42 C 14.1 21.81 13.95 21.81 13.32 21.39 C 12.9 21.12 10.86 20.7 8.61 20.4 C 3.78 19.74 2.52 19.41 1.08 18.45 L -0.06 17.67 L -1.02 18.3 C -2.73 19.35 -4.53 19.83 -8.79 20.4 C -11.64 20.76 -13.11 21.09 -13.5 21.45 C -13.92 21.84 -14.19 21.87 -14.67 21.63 C -15.24 21.3 -17.7 18 -17.7 17.52 C -17.7 17.07 -16.08 15.21 -15.18 14.67 C -14.43 14.22 -13.68 14.1 -11.19 14.1 C -8.16 14.1 -5.1 13.62 -5.1 13.14 C -5.1 13.02 -5.43 12.9 -5.85 12.9 C -6.9 12.9 -8.31 12.12 -8.52 11.46 C -8.61 11.19 -8.43 10.02 -8.1 8.88 L -7.53 6.84 L -8.7 5.13 C -11.61 0.84 -11.43 -2.58 -8.07 -5.97 C -6.81 -7.23 -4.32 -9 -3.24 -9.39 C -2.79 -9.54 -2.82 -9.66 -3.36 -10.77 C -4.14 -12.33 -3.9 -13.86 -2.7 -15.06 C -1.98 -15.78 -1.62 -15.9 -0.24 -15.9 C 0.81 -15.9 1.68 -15.69 2.31 -15.33 Z M -1.02 -13.32 C -1.59 -12.78 -1.62 -12.48 -1.2 -11.67 C -0.6 -10.56 1.2 -11.13 1.2 -12.45 C 1.2 -13.71 -0.12 -14.22 -1.02 -13.32 Z M -0.96 -4.14 C -0.87 -3.03 -0.87 -3 -1.92 -3 C -2.94 -3 -3 -2.94 -3 -1.98 C -3 -1.02 -2.91 -0.93 -2.04 -0.84 C -1.11 -0.75 -1.05 -0.66 -1.05 0.39 C -1.05 1.44 -0.99 1.5 -0.09 1.5 C 0.87 1.5 0.9 1.44 0.9 0.3 C 0.9 -0.81 0.96 -0.9 1.77 -0.9 C 2.49 -0.9 2.64 -1.05 2.76 -1.8 C 2.91 -2.88 2.85 -3 1.74 -3 C 0.96 -3 0.9 -3.09 0.9 -4.23 C 0.9 -5.4 0.87 -5.43 -0.09 -5.34 C -1.02 -5.25 -1.05 -5.19 -0.96 -4.14 Z M -5.31 4.98 C -5.4 5.25 -5.31 5.58 -5.07 5.73 C -4.59 6.06 4.95 5.97 5.25 5.64 C 5.37 5.52 5.4 5.22 5.31 4.95 C 5.01 4.26 -5.04 4.26 -5.31 4.98 Z M -4.92 7.98 C -5.55 8.22 -5.52 8.88 -4.89 9.15 C -4.59 9.27 -2.64 9.42 -0.57 9.51 C 4.14 9.72 6.57 9.09 4.86 8.13 C 4.32 7.8 -4.14 7.68 -4.92 7.98 Z"""
                else """M 0 -24 c 1.568 0.48 2.464 1.696 2.464 3.328 c 0 0.8 -0.224 1.792 -0.544 2.272 c -0.32 0.48 -0.512 0.864 -0.448 0.896 c 5.856 2.912 9.056 7.04 8.384 10.912 c -0.256 1.568 -1.376 3.872 -2.56 5.28 l -0.832 1.024 l 0.512 2.048 c 0.288 1.12 0.512 2.336 0.512 2.688 c 0 0.928 -0.832 1.6 -2.496 2.016 l -1.504 0.384 l 1.6 0.448 c 0.928 0.256 2.976 0.448 4.928 0.416 c 3.808 -0 4.512 0.256 6.24 2.24 l 1.12 1.312 l -1.216 1.824 c -0.672 0.992 -1.536 2.08 -1.92 2.4 c -0.608 0.576 -0.704 0.576 -1.248 0.096 c -0.352 -0.32 -1.952 -0.672 -4.704 -1.024 c -4.864 -0.608 -6.88 -1.152 -8.544 -2.24 l -1.184 -0.8 l -1.152 0.672 c -1.696 1.024 -3.776 1.568 -8.256 2.208 c -2.496 0.352 -4.416 0.8 -4.928 1.152 l -0.864 0.544 l -1.28 -1.44 c -0.736 -0.8 -1.568 -1.888 -1.856 -2.4 c -0.544 -0.96 -0.544 -0.992 0.352 -2.24 c 1.376 -1.888 2.592 -2.336 6.176 -2.272 c 3.2 0.096 7.04 -0.608 5.856 -1.056 c -0.352 -0.128 -1.12 -0.416 -1.696 -0.608 c -1.6 -0.608 -1.728 -1.184 -0.992 -3.84 l 0.672 -2.336 l -0.672 -0.832 c -1.376 -1.76 -2.336 -3.648 -2.688 -5.312 c -0.288 -1.472 -0.256 -2.016 0.224 -3.584 c 0.864 -2.752 3.84 -5.536 8.128 -7.68 c 0.064 -0.032 -0.096 -0.384 -0.352 -0.8 c -1.6 -2.56 -0.256 -5.504 2.688 -5.856 c 0.608 -0.064 1.536 -0 2.08 0.16 z m -2.752 2.56 c -0.352 0.352 -0.64 0.864 -0.64 1.12 c 0 0.672 1.152 1.76 1.856 1.76 c 0.96 -0 1.728 -0.8 1.728 -1.76 c -0 -1.632 -1.76 -2.304 -2.944 -1.12 z m -0.8 5.728 c -2.016 0.928 -5.184 3.424 -6.112 4.832 c -1.6 2.432 -1.216 5.984 0.8 7.168 c 2.016 1.152 12.096 1.28 14.528 0.16 c 1.792 -0.832 2.656 -4.096 1.632 -6.24 c -1.248 -2.656 -6.464 -6.528 -8.736 -6.528 c -0.448 0 -1.408 0.288 -2.112 0.608 z m -4.064 15.712 l 0.128 1.12 l 6.016 -0 l 6.016 -0 l 0.128 -1.12 l 0.096 -1.12 l -6.24 0 l -6.24 0 l 0.096 1.12 z m 0.096 3.2 c -0.896 0.448 -0.864 1.152 0.032 1.376 c 1.408 0.352 8.8 0.64 10.624 0.416 c 1.856 -0.256 2.56 -0.832 1.824 -1.568 c -0.8 -0.8 -11.04 -1.024 -12.48 -0.224 z m 3.936 4.32 c -2.144 1.536 -3.776 1.984 -8.448 2.368 c -3.456 0.288 -4.064 0.416 -4.544 1.024 c -0.448 0.512 -0.48 0.8 -0.224 1.312 c 0.32 0.576 0.544 0.608 2.784 0.416 c 6.464 -0.544 10.208 -1.568 11.712 -3.2 l 0.768 -0.832 l 0.832 0.832 c 1.088 1.088 3.072 1.952 5.472 2.368 c 3.456 0.576 8.416 1.056 8.768 0.832 c 0.192 -0.096 0.352 -0.544 0.352 -0.992 c -0 -1.152 -1.376 -1.6 -5.44 -1.824 c -4.192 -0.256 -5.472 -0.608 -7.68 -2.176 c -0.96 -0.672 -1.984 -1.248 -2.272 -1.248 c -0.256 0 -1.216 0.512 -2.08 1.12 z M -0.448 -11.616 c 0.096 1.056 0.224 1.216 0.96 1.312 c 0.8 0.096 0.896 0.256 0.896 1.216 c 0 0.992 -0.064 1.088 -0.96 1.088 c -0.896 0 -0.96 0.064 -0.96 1.28 c 0 1.216 -0.064 1.28 -0.96 1.28 c -0.896 0 -0.96 -0.064 -0.96 -1.248 c -0 -1.184 -0.064 -1.28 -1.056 -1.376 c -0.896 -0.096 -1.024 -0.224 -1.12 -1.12 c -0.096 -0.928 -0.032 -1.024 0.96 -1.12 c 0.96 -0.096 1.056 -0.192 1.152 -1.312 c 0.096 -1.056 0.192 -1.184 1.024 -1.184 c 0.832 -0 0.928 0.128 1.024 1.184 z"""
            case Pawn(isWhite) => 
                if isWhite then """M 2 -20 c 2.464 0.736 3.712 3.296 2.912 5.952 c -0.416 1.376 -0.416 1.568 0.032 1.824 c 1.248 0.704 2.688 2.272 3.04 3.328 c 0.768 2.304 -0.224 5.6 -2.016 6.624 l -0.992 0.608 l 1.088 0.544 c 1.632 0.864 4.032 3.104 4.928 4.608 c 1.056 1.792 1.76 4.96 1.76 7.936 l 0 2.496 l -12.512 0 l -12.544 0 l 0.192 -3.296 c 0.096 -1.792 0.416 -4 0.704 -4.896 c 0.768 -2.272 2.528 -4.48 4.8 -6.016 l 1.952 -1.312 l -1.344 -1.28 c -1.504 -1.44 -1.92 -2.784 -1.568 -5.12 c 0.192 -1.44 1.632 -3.328 3.136 -4.16 c 0.544 -0.288 0.544 -0.416 0.064 -1.824 c -1.344 -3.872 2.208 -7.232 6.368 -6.016 z m -2.72 1.92 c -0.576 0 -1.568 1.28 -1.568 2.048 c 0 0.416 0.288 1.376 0.608 2.112 c 0.352 0.768 0.544 1.568 0.448 1.792 c -0.064 0.224 -0.704 0.768 -1.408 1.248 c -1.664 1.088 -2.528 2.528 -2.528 4.256 c 0 1.44 0.544 2.176 2.816 4 c 0.928 0.736 0.544 1.504 -1.472 2.88 c -4.128 2.848 -5.792 5.376 -6.08 9.184 l -0.16 2.24 l 10.336 -0 l 10.336 -0 l -0.16 -2.24 c -0.288 -3.872 -1.728 -5.984 -6.336 -9.376 c -1.856 -1.376 -1.984 -2.144 -0.48 -3.328 c 2.944 -2.272 2.752 -5.376 -0.448 -7.648 c -1.408 -1.024 -1.632 -1.888 -0.832 -3.328 c 1.184 -2.08 -0.256 -4.512 -2.336 -3.968 c -0.256 0.064 -0.576 0.128 -0.736 0.128 z"""
                else """M 1.6 -16 c 2.176 1.12 2.912 3.232 2.048 5.696 c -0.288 0.768 -0.48 1.44 -0.448 1.472 c 0.064 0.032 0.64 0.352 1.28 0.768 c 2.144 1.28 3.104 4.672 2.048 7.168 c -0.224 0.576 -0.896 1.44 -1.472 1.952 c -0.832 0.704 -0.96 0.928 -0.608 1.152 c 1.6 0.896 3.904 2.944 4.736 4.16 c 1.504 2.24 2.016 4 2.176 7.744 l 0.192 3.456 l -12.576 0 l -12.576 0 l 0.192 -3.456 c 0.128 -2.336 0.384 -4 0.864 -5.248 c 0.8 -2.144 2.976 -4.704 4.992 -5.888 c 0.768 -0.448 1.408 -0.896 1.408 -0.992 c -0 -0.096 -0.384 -0.448 -0.832 -0.832 c -0.992 -0.768 -2.016 -2.88 -2.048 -4.192 c -0 -1.696 0.736 -3.392 1.92 -4.48 c 0.672 -0.576 1.376 -1.12 1.6 -1.216 c 0.352 -0.096 0.352 -0.352 0.064 -1.216 c -0.224 -0.576 -0.384 -1.664 -0.384 -2.432 c -0 -3.328 4.128 -5.376 7.424 -3.616 z"""
            case Empty => ""
        out.replaceAll("\n", "")
        
}
